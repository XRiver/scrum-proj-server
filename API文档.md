### 一、实体类

##### 1 用户

```typescript
User {
    uId: string; // 数据库自增id，也是用户唯一标识
    openId: string; // 微信号唯一标识
    uName： string; // 真实姓名
	school: string;// 学校名称
    picture：string；// 用户头像
}
```

##### 2 景点

```typescript
Attraction {
    aId: String; // 数据库自增id，也是唯一标识
	aName: String; // 景点名称
    location: String; // 景点位置
    pictureUrl: String; // 景点图片URL
    description: String; // 对景点的描述
}
```

##### 3 出行计划

```typescript
Plan {
	pId: String; // 数据库自增id，也是唯一标识
    creatorName: String; // 创建者姓名
    aName: String; // 景点名字
    travelTime: DateTime; // 出行时间
	detail: String; // 计划详细信息
	applyList: List<String>; // 申请者的列表，存放申请加入此出行计划的用户uId
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
GET /api/login?openid=openid
```

```
{
	'openid': openid // 登录者的openid
}
```

response

```json
{
    'status'： number 或 'data':user的json对象                                                                  // 失败——返回字符串0；登录成功——返回改user的json对象；
                       //无此用户,需要注册——返回字符串2.
}
```

##### 2 注册

request

```shell
POST /api/signon
```

```json
{
    User的json对象（包含User各个属性）
}
```

response

```json
{
    'status'： number, // 0-失败 1-注册成功
}
```

##### 3 获取所有景点简略信息

request

```shell
GET /api/attractions
```

```json
{
	type: "all"//表示查询所有景点
}
```

response

```json
{
    'data': [{Attraction实体(仅包含id、名称、图片URL)}...]
}
```

##### 4 获取单个景点详细信息

request

```shell
GET /api/attractions
```

```json
{
	type: "single";//表示查询单个景点详细信息 
    aId: String; // 景点唯一标识号
}
```

response

```json
{
    'data': {Attraction实体}
}
```

##### 5 创建出行计划

request

```shell
post /api/createPlan
```

```json
{
	Plan的Json对象（包含Plan各个属性）
}
```

response

```json
{
    'status'： number, // 0-创建失败 1-创建成功
}
```

##### 6 按照景点名搜索出行计划

request

```shell
GET /api/plans
```

```json
{
	aName: String; // 景点名称 
    type: "aName";//表示根据景点名查询
}
```

response

```json
{
    'data': [{Plan实体1}，{Plan实体2}...]
}
```

##### 7 按照计划创建者搜索出行计划

request

```shell
GET /api/plans
```

```json
{
	uName： string; // 创建者姓名   
    type:"uName";//表示根据创建者姓名查询
}
```

response

```json
{
    'data': [{Plan实体1}，{Plan实体2}...]
}
```

##### 8 申请加入某个出行计划

request

```shell
POST /api/joinPlan
```

```json
{
	openId: string; // 申请者的微信号唯一标识  
    pId: String; // 出行计划的唯一标识号
	mess: String; // 申请者的留言
}
```

response

```json
{
    'status'： number, // 0-申请失败 1-申请成功
}
```
