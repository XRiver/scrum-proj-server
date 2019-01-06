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
    creatorname: String; // 创建者姓名
    aname: String; // 景点名字
    traveltime: Date; // 出行时间
	detail: String; // 计划详细信息
	applylist: String; // 申请者的列表，存放申请加入此出行计划的用户openid
}
```

##### 4 申请信息

```typescript
Apply {
	applyid: Integer;// 数据库自增id，也是唯一标识
    openid: String; // 申请者微信openid
    pid: Integer;  // 景点编号
    mess: String; // 申请者留言
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
GET /api/login?openid=value
```

​      //参数openid为'string'类型,表示用户微信号唯一标识

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
GET /api/attractions？type=all
```

​	//参数 type 为'string'类型, 值为 all 则表示查询所有景点

response

```json
{
    'data': [{Attraction实体(仅包含id、名称、图片URL)}...]
}
```

##### 4 获取单个景点详细信息

request

```shell
GET /api/attractions？type=single&aid=value
```

​	//参数 type 为'string'类型,值为 single 则表示查询具体单个景点

​	//参数 aid 为'int'类型,表示具体查询的景点编号

response

```json
{
    'data': {Attraction实体}
}
```

##### 5 创建出行计划

request

```shell
post /api/plan/create
```

```json
{
	Plan的Json对象（包含Plan属性：aname creatorname traveltime detail）
}
```

response

```json
{
    'code'： number  //0-创建成功  1-创建失败，未传入aname或creatorname
    'msg':   string  //说明 
    'data':  {}    //json对象
}
```

##### 6 按照景点名搜索出行计划

request

```shell
GET /api/plans?type=aname&aname=value
```

​       //参数 type 为'string'类型,值为 aname 则表示根据景点名搜索出行计划

​       //参数 aname 为'string'类型,表示景点名字	

response

```json
{
    'data': [{Plan实体1}，{Plan实体2}...]
}
```

##### 7 按照计划创建者搜索出行计划

request

```shell
GET /api/plans?type=uname&uname=value
```

​	//参数 type 为'string'类型,值为 uname 则表示根据创建者姓名搜索出行计划

​       //参数 uname 为'string'类型,表示创建者姓名	

response

```json
{
    'data': [{Plan实体1}，{Plan实体2}...]
}
```

##### 8 申请加入某个出行计划

request

```shell
POST /api/plan/apply
```

```json
{
	openid: string; // 申请者的微信号唯一标识  
    pid: String; // 出行计划的唯一标识号
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
