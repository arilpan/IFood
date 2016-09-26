# IFood
# 总体说明：
- 1.come.example.jpushdemo为拷贝jpush相关代码，配置接收jpush推送
- 2.com.ydxiaoyuan.ifood为本人所写代码
- 3.com.fan.eightrestaurant为朋友所写代码
- 4.com.zfeng.swiperefreshload为使用的github第三方下拉加载类，经过修改，相应修改代码已pull到相应作者

# com.ydxiaoyuan.ifood代码结构说明
* adapter为所有ui使用到的适配器
* api为与服务器交互信息
* base为界面基本文件
* entity为初始预定与服务器交互实体类，后来根据服务器端信息弃用了除了Dish以外的其他实体类
* event为定义的EventBus事件
* fragment为首页基本4栏界面
* helper为使用到的帮助类
* listener为自定义事件监听器
* ui为除了main和fragment以外的所有用户接口
* view为自定义的view

# 代码发布说明
由于本项目必须与相应配套服务器使用，但是服务器程序目前无法开源且无法在公网发布，故而使用APIStaticInfo将先前获取到的数据进行静态传递给相应的api获取函数。




