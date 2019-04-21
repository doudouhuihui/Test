package DesignMode.Future;

public class FutureData implements Data {

    protected RealData realData = null;

    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();       //RealData已经被注入，通知getResult()
    }


    @Override
    public synchronized String getResult() {   //会等待RealData注入完成
        while (!isReady){
            try {
                wait();  //会一起等待，直到RealData被注入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getResult();    //由RealData实现
    }
}
