package j5character;

/*****************************************************************************
 * @className: UserDO.java
 * @date : 2020-03-19 11:33
 * @author : 樊玺   (fanxi@vvise.com)
 * @module : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ******************************************************************************/
public class UserDO {

    @NotEmpty(msg = "姓名不能为空！")
    private String name;
    private int age;
    private Object obj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
