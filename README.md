## Ethan（伊森）



### 简介：<br>

伊森对于钢铁侠(托尼·斯塔克)来说除了以生命为代价拯救钢铁侠姓名以外，还为钢铁侠创造反应堆提供了灵感。
不过这些都不是最重要的。
最重要的是：奥创事件前的托尼·斯塔克一直都没有想成为一个超级英雄，但是众多的偶然事件和自己的仇敌报复行动一次次地将他拉到了风口浪尖（他甚至是因为被绑架才不得不发明钢铁战甲），他才勉强做出这些“英雄”壮举。
而伊森用生命助他成为钢铁侠，也是托尼·斯塔克从混蛋慢慢向一个充满人情味的英雄过渡的开始。

###### 电影对话桥段：<br>

Ethan：Stark <br>
Stark：Come on，you are gonna go see your family。Get up <br>
Ethan：My family is dead.I am going to see them now,Stark .It is OK. I want this(我没有牵挂了) <br>
Stark：Thank you for saving me.（你救了我）<br>
Ethan：Do not waste it,Do not waste your life.（那就好好珍惜它，别浪费生命）<br>

###### 版本更新：<br>

|版本|更新说明|
|---|---|
|Version: 1.0|Ethan机器人的基础能力构建来自于PrivateJarvis项目|
|Version: 2.0|实现Ethan可提供三种服务能力：<br> 1(支持天气查询) <br> 2(支持可根据所设置的提醒时间，定时发送微信消息) <br> (支持可关闭提醒服务)|

### OpenApi

###### Package：<br>

|Package|描述|
|---|---|
|src.com.db|用于操作数据库|
|src.com.gaode|用于接入高德Api|
|src.com.globalinterface|用于Ehtan项目的接口定义|
|src.com.network |用于定义线上接口的网络对接能力|
|src.com.service|Ethan机器人的服务能力输出 |
|src.com.weixin|用于接入微信Api|


###### Package src.com.db<br>
|Class|描述 |备注|
|---|---|---|
|CreaDatateSheet|创建数据库和数据表|未启用|
|InsertDatate|数据插入到数据库服务|未启用|
|SelectDatate|数据库查询服务||


###### Package src.com.gaode<br>
|Class|描述 |备注|
|---|---|---|
|WeatherInfo|获取天气数据信息||

###### Package src.com.globalinterface<br>
|Interface|描述 |备注|
|---|---|---|
|GaoDeInterface|定义高德接口||
|WeiXinInterface|定义微信接口||

###### Package src.com.network<br>
|Class|描述 |备注|
|---|---|---|
|JsoupNet|Jsoup接入网络结构能力||

###### Package src.com.weixin<br>
|Class|描述 |备注|
|---|---|---|
|AccessToken|获取微信网络令牌(TOKEN)||
|Message|微信消息发送能力||
|MessageContent|微信消息发送的Json参数定义||
|TimingDevice|定义定时发送微信消息||

###### Package src.com.service<br>
|Class|描述 |备注|
|---|---|---|
|Dialogue|Ethan机器人的服务能力||










