### 一、实体类

##### 1 用户

```typescript
User {
    uid: Integer; // 数据库自增id，也是用户唯一标识
    openid: string; // 微信号唯一标识
    uname： string; // 真实姓名
	school: string;// 学校名称
    pictureurl：string；// 用户头像地址
    sex: string;      //性别
    nickname:string  //用户昵称
    city: string    //用户所在城市
}
```

##### 2 景点

```typescript
Attraction {
    aid: Integer; // 数据库自增id，也是唯一标识
	aname: String; // 景点名称
    location: String; // 景点位置
    pictureurl: String; // 景点图片URL
    description: String; // 对景点的描述
}
```

##### 3 出行计划

```typescript
Plan {
    pid: Integer; // 数据库自增id，也是唯一标识
    openid: String; // 创建者用户openid
    aid: Integer; // 景点编号
    traveltime: String; // 出行时间 时间戳
	detail: String; // 计划详细信息
	applylist: String; // 申请者的列表，存放申请加入此出行计划的用户openid
	aname：String；   //景点名称
	uname：String；   //创建者姓名
	applylist：String； //申请者的编号，以逗号分隔
    state: String  //出行计划的状态 0-未出行、1-正在进行、2-行程结束、3-过期作废
}
```

##### 4 申请信息

```typescript
Apply {
	applyid: Integer;// 数据库自增id，也是唯一标识
    openid: String; // 申请者微信openid
    pid: Integer;  // 出行计划编号
    mess: String; // 申请者留言
    pass: Integer //通过或拒绝申请 0-拒绝  1-通过
    deal: Integer //该申请是否已被审批过  0-尚未处理  1-已处理
}
```

##### 5 团队成员的评价

```typescript
Evaluation {
	eid: Integer;// 数据库自增id，也是唯一标识
    pid: Integer // 出行计划编号pid
    fromid: String; // 评价者的微信openid
    toid: String;  // 被评价者的微信openid
    mess: String; // 评价信息
}
```


### 二、对于空的处理

在我们实际开发中:

只要出现空的情况，一律返回`null`

### 三、标准返回格式

每api均返回json格式的数据

### 四、具体用例以及对应的api

##### 1 登录

request

```html
GET /api/login/{openid}
```

      //参数openid为'string'类型,表示用户微信号唯一标识

response

```json
{
    'code'： number  //0-登录成功   1-未传入openid   2-无此用户,需要注册
    'msg':   string  //说明 
    'data':  {User实体}    //登录成功时返回json对象
}
```

##### 2 注册

request

```shell
POST /api/register
```

```json
{
    User的json对象（包含User属性：openid uname school pictureurl sex nickname city）
}
    //openid: string;  微信号唯一标识
    //uname： string;  真实姓名
	//school: string;  学校名称
    //pictureurl：string； 用户头像地址
    //sex: string;  (必须为汉字"男"或“女”)  性别
    //nickname:string  用户昵称
    //city: string    用户所在城市
```

response

```json
{
    'code'： number  //0-注册成功  1-没有传入openid  2-此openid已经存在
    'msg':   string  //说明 
    'data':  {}    //json对象
}
```

##### 3 获取所有景点简略信息

request

```shell
GET /api/attractions
```



response

```json
[
    {Attraction实体},
    ...
]
    //aid: Integer; // 数据库自增id，也是唯一标识
	//aname: String; // 景点名称
    //location: String; // 景点位置
    //pictureurl: String; // 景点图片URL
    //description: String; // 对景点的描述
```

##### 4 获取单个景点详细信息

request

```shell
GET /api/attractions/{aid}
```


	//参数 aid 为'int'类型,表示具体查询的景点编号

response

```json
[
    {Attraction实体}
]
    //aid: Integer; // 数据库自增id，也是唯一标识
	//aname: String; // 景点名称
    //location: String; // 景点位置
    //pictureurl: String; // 景点图片URL
    //description: String; // 对景点的描述
```

##### 5 创建出行计划

request

```shell
post /api/plan
```

```json
{
	Plan的Json对象（包含Plan属性：aid openid traveltime detail）
}
	//aid: Integer;  景点编号
    //openid: String;  创建者openid
    //traveltime: String;出行时间 时间戳
	//detail: String;  计划详细信息
```

response

```json
{
    'code'： number  //0-创建成功  1-创建失败，未传入aname或creatorname
    'msg':   string  //说明 
    'data':  {}    //json对象
}
```

##### 6 按照用户openid搜索出行计划

request

```shell
GET /api/plan/openid/{openid}？state=value
//传入的state是一个字符串，为几种状态码的组合，其中状态吗0-未出行、1-正在进行、2-行程结束、3-过期作废
//state形如 "0"、"3"、"012"、"013"、"0123" 等
```

response

```json
[
    {Plan实体1}，{Plan实体2}...
]
	//pid: Integer;  计划编号
	//aid: Integer;  景点编号
    //openid: String;  创建者openid
	//aname：String；   景点名称
	//uname：String；   创建者姓名
    //traveltime: String;出行时间 时间戳
	//detail: String;  计划详细信息
	//applylist：String； 申请者的编号，以逗号分隔
```

##### 7 按照用户姓名搜索出行计划

request

```shell
GET /api/plan/uname/{uname}？state=value
//传入的state是一个字符串，为几种状态码的组合，其中状态吗0-未出行、1-正在进行、2-行程结束、3-过期作废
//state形如 "0"、"3"、"012"、"013"、"0123" 等
```

response

```json
[
    {Plan实体1}，{Plan实体2}...
]
	//pid: Integer;  计划编号
	//aid: Integer;  景点编号
    //openid: String;  创建者openid
	//aname：String；   景点名称
	//uname：String；   创建者姓名
    //traveltime: String;出行时间 时间戳
	//detail: String;  计划详细信息
	//applylist：String； 申请者的编号，以逗号分隔
```
##### 8 按照景点名搜索出行计划

request

```shell
GET /api/plan/attraction/{aname}？state=value
//传入的state是一个字符串，为几种状态码的组合，其中状态吗0-未出行、1-正在进行、2-行程结束、3-过期作废
//state形如 "0"、"3"、"012"、"013"、"0123" 等
```

response

```json
[
    {Plan实体1}，{Plan实体2}...
]
	//pid: Integer;  计划编号
	//aid: Integer;  景点编号
    //openid: String;  创建者openid
	//aname：String；   景点名称
	//uname：String；   创建者姓名
    //traveltime: String;出行时间 时间戳
	//detail: String;  计划详细信息
	//applylist：String； 申请者的编号，以逗号分隔
```

##### 9 申请加入某个出行计划

request

```shell
POST /api/plan/apply
```

```json
{
	openid: string; // 申请者的微信号唯一标识  
    pid: Integer; // 出行计划的唯一标识号
	mess: String; // 申请者的留言
}
```

response

```json
{
    'code'： number  //0-申请成功  1-申请失败,未传入openid或pid  2-该用户已申请过此出行计划
    'msg':   string  //说明 
    'data':  {}    //json对象
}
```

##### 10 查询尚未审批的的出行申请信息

request

```shell
GET /api/plan/apply/{pid}
```

response

```json
{
	'code'： number  //0-查询成功  1-查询失败
    'msg':   string  //说明 
    'data':  [{"mess": string,"applyid": number,"applicant":{User实体类}}，]   
}
    //openid: string;  微信号唯一标识
    //uname： string;  真实姓名
	//school: string;  学校名称
    //pictureurl：string； 用户头像地址
    //sex: string;  (必须为汉字"男"或“女”)  性别
    //nickname:string  用户昵称
    //city: string    用户所在城市
```

//返回的是申请的mess+申请的applyid+每个申请的申请人的信息（封装成一个嵌套的User实体类）

##### 11 同意/拒绝对出行计划的申请

request

```shell
PUT /api/plan/apply
```
```json
{
    'applyid': number  //申请的applyid编号
    'pass': nunber  //表示是否同意该申请 1代表同意 0代表不同意 NULL表示未审核状态
}
```

response

```json
{
    'code'： number  //0-同意/拒绝申请成功  1-同意/拒绝申请失败 
    'msg':   string  //说明
}
```
##### 12 切换出行计划的状态码

request

```shell
PUT /api/plan/state
```
```json
{
    ‘pid’: Integer; // 出行计划的唯一标识号
	‘state’: String; // 改成哪种状态吗 ”0“-未出行、”1“-正在进行、”2“-行程结束、”3“-过期作废
}
```

response

```json
{
	'code'： number  //0-修改成功   1-本来就是这个状态，不用修改   2-修改失败
    'msg':   string  //说明 
    'data':  {Plan实体类} 
}
```

##### 13 评价团队成员

request

```shell
post /api/plan/evaluation
```

```json
{
	Evaluation的Json对象（包含Evaluation属性：eid pid fromid toid mess）
}
	//eid: Integer;    数据库自增id，也是唯一标识
    //pid: Integer     出行计划编号pid
    //fromid: String;  评价者的微信openid
    //toid: String;    被评价者的微信openid
    //mess: String;    评价信息
```

response

```json
{
    'code'： number  //0-评价成功  1-评价失败
    'msg':   string  //说明 
    'data':  {}    //空
}
```

