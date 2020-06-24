
**华润通游戏积分系统**


**简介**：<p>华润通游戏积分系统</p>


**HOST**:192.168.0.19:8084

**联系人**:lxstella

**Version**:1.0.0

**接口路径**：/v2/api-docs?group=车凌


# banner管理 (管理端))

## 删除按钮

**接口描述**:根据按钮ID删除按钮

**接口地址**:`/manage/banner`


**请求方式**：`DELETE`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|bannerId| bannerID  | query | true |integer  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 204 | No Content  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
## 查找Banner


**接口描述**:


**接口地址**:`/manage/banner/list`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"attribute": "",
			"bannerName": "",
			"bannerPic": "",
			"createTime": 0,
			"id": 0,
			"sort": 0,
			"status": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | BannerVO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**BannerVO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|attribute | banner属性   |string  |    |
|bannerName | banner名称   |string  |    |
|bannerPic | banner图片url   |string  |    |
|createTime | 创建时间   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|sort | 排序   |integer(int32)  |    |
|status | 状态   |integer(int32)  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«BannerVO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 修改&更新Banner


**接口描述**:


**接口地址**:`/manage/banner/save`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"attribute": "",
	"bannerName": "",
	"bannerPic": "",
	"id": 0,
	"sort": 0,
	"type": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|bannerDTO| 按钮DTO  | body | true |DTO  | DTO   |

**schema属性说明**



**DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|attribute| banner属性  | body | false |string  |    |
|bannerName| banner名称  | body | false |string  |    |
|bannerPic| banner图片url  | body | false |string  |    |
|id| 主键  | body | false |integer(int64)  |    |
|sort| 排序  | body | false |integer(int32)  |    |
|type| 类型  | body | false |integer(int32)  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取Banner类型列表


**接口描述**:


**接口地址**:`/manage/banner/types`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json
[
	{
		"field": "",
		"key": 0,
		"value": [
			{
				"key": "",
				"value": ""
			}
		]
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|field|   |string  |    |
|key|   |integer(int32)  | integer(int32)   |
|value|   |array  | KeyValue«string,string»   |



**schema属性说明**




**KeyValue«string,string»**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|key |    |string  |    |
|value |    |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |KeyFieldValue«int,string,List«KeyValue«string,string»»»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 下架 banner


**接口描述**:


**接口地址**:`/manage/banner/updateToOffline/{bannerId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|bannerId| bannerId  | path | true |integer  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 上架 banner


**接口描述**:


**接口地址**:`/manage/banner/updateToOnline/{bannerId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|bannerId| bannerId  | path | true |integer  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# third-auth-controller

## 三方认证


**接口描述**:


**接口地址**:`/api/third/auth`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"alias": "",
	"client_id": "",
	"media_source": "",
	"openId": "",
	"platform": "",
	"redirectUrl": "",
	"response_type": "",
	"sign": "",
	"timestamp": "",
	"userInfo": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|thirdAuthDTO| thirdAuthDTO  | body | true |三方认证DTO  | 三方认证DTO   |

**schema属性说明**



**三方认证DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|alias|   | body | false |string  |    |
|client_id|   | body | false |string  |    |
|media_source|   | body | false |string  |    |
|openId|   | body | false |string  |    |
|platform|   | body | false |string  |    |
|redirectUrl|   | body | false |string  |    |
|response_type|   | body | false |string  |    |
|sign|   | body | false |string  |    |
|timestamp|   | body | false |string  |    |
|userInfo|   | body | false |string  |    |

**响应示例**:

```json
{
	"applicationContext": {
		"applicationName": "",
		"autowireCapableBeanFactory": {},
		"beanDefinitionCount": 0,
		"beanDefinitionNames": [],
		"classLoader": {
			"parent": {
				"parent": {}
			}
		},
		"displayName": "",
		"environment": {
			"activeProfiles": [],
			"defaultProfiles": []
		},
		"id": "",
		"parent": {},
		"parentBeanFactory": {},
		"startupDate": 0
	},
	"attributesMap": {},
	"beanName": "",
	"contentType": "",
	"exposePathVariables": true,
	"hosts": [],
	"propagateQueryProperties": true,
	"redirectView": true,
	"requestContextAttribute": "",
	"staticAttributes": {},
	"url": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|applicationContext|   |ApplicationContext  | ApplicationContext   |
|attributesMap|   |object  |    |
|beanName|   |string  |    |
|contentType|   |string  |    |
|exposePathVariables|   |boolean  |    |
|hosts|   |array  |    |
|propagateQueryProperties|   |boolean  |    |
|redirectView|   |boolean  |    |
|requestContextAttribute|   |string  |    |
|staticAttributes|   |object  |    |
|url|   |string  |    |



**schema属性说明**




**ApplicationContext**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|applicationName |    |string  |    |
|autowireCapableBeanFactory |    |AutowireCapableBeanFactory  | AutowireCapableBeanFactory   |
|beanDefinitionCount |    |integer(int32)  |    |
|beanDefinitionNames |    |array  |    |
|classLoader |    |ClassLoader  | ClassLoader   |
|displayName |    |string  |    |
|environment |    |Environment  | Environment   |
|id |    |string  |    |
|parent |    |ApplicationContext  | ApplicationContext   |
|parentBeanFactory |    |BeanFactory  | BeanFactory   |
|startupDate |    |integer(int64)  |    |

**AutowireCapableBeanFactory**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |



**ClassLoader**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|parent |    |ClassLoader  | ClassLoader   |

**Environment**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|activeProfiles |    |array  |    |
|defaultProfiles |    |array  |    |

**BeanFactory**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |RedirectView|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 三方渠道表 (管理端))

## 获取单个三方渠道信息


**接口描述**:


**接口地址**:`/manage/thirdChannel`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelId| channelId  | query | true |integer  |    |

**响应示例**:

```json
{
	"channelDailyThreshold": 0,
	"channelDailyUserThreshold": 0,
	"channelId": 0,
	"channelKey": "",
	"channelName": "",
	"channelStatus": 0,
	"chargeRatio": 0,
	"createTime": 0,
	"lastOperatorId": 0,
	"logs": [
		{
			"channelId": 0,
			"createTime": 0,
			"id": 0,
			"operatorId": 0,
			"remark": "",
			"stateChange": ""
		}
	],
	"pointExchangeRate": 0,
	"pointName": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|channelDailyThreshold| 日发放限额  |integer(int64)  | integer(int64)   |
|channelDailyUserThreshold| 用户日充值限额  |integer(int64)  | integer(int64)   |
|channelId| 渠道id  |integer(int64)  | integer(int64)   |
|channelKey| 渠道key  |string  |    |
|channelName| 渠道名称  |string  |    |
|channelStatus| 渠道状态  |integer(int32)  | integer(int32)   |
|chargeRatio| 兑换服务费比例  |integer(int32)  | integer(int32)   |
|createTime| 创建时间  |integer(int64)  | integer(int64)   |
|lastOperatorId| 最后操作人id  |integer(int64)  | integer(int64)   |
|logs| 创建时间  |array  | 三方渠道操作日志表VO   |
|pointExchangeRate| 被兑换积分汇率(RMB)  |integer(int32)  | integer(int32)   |
|pointName| 被兑换积分名称  |string  |    |



**schema属性说明**




**三方渠道操作日志表VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|channelId | 渠道id   |integer(int64)  |    |
|createTime | 时间   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|operatorId | 操作人id   |integer(int64)  |    |
|remark | 备注   |string  |    |
|stateChange | 状态变更   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |三方渠道表VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 新增 三方渠道


**接口描述**:


**接口地址**:`/manage/thirdChannel`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"channelDailyThreshold": 0,
	"channelDailyUserThreshold": 0,
	"channelId": 0,
	"channelName": "",
	"chargeRatio": 0,
	"pointExchangeRate": 0,
	"pointName": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|thirdChannelDTO| thirdChannelDTO  | body | true |三方渠道表DTO  | 三方渠道表DTO   |

**schema属性说明**



**三方渠道表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|channelDailyThreshold| 日发放限额  | body | false |integer(int64)  |    |
|channelDailyUserThreshold| 用户日充值限额  | body | false |integer(int64)  |    |
|channelId| 渠道id  | body | false |integer(int64)  |    |
|channelName| 渠道名称  | body | false |string  |    |
|chargeRatio| 兑换服务费比例  | body | false |integer(int32)  |    |
|pointExchangeRate| 被兑换积分汇率(RMB)  | body | false |integer(int32)  |    |
|pointName| 被兑换积分名称  | body | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 修改 三方渠道


**接口描述**:


**接口地址**:`/manage/thirdChannel`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"channelDailyThreshold": 0,
	"channelDailyUserThreshold": 0,
	"channelId": 0,
	"channelName": "",
	"chargeRatio": 0,
	"pointExchangeRate": 0,
	"pointName": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|thirdChannelDTO| thirdChannelDTO  | body | true |三方渠道表DTO  | 三方渠道表DTO   |

**schema属性说明**



**三方渠道表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|channelDailyThreshold| 日发放限额  | body | false |integer(int64)  |    |
|channelDailyUserThreshold| 用户日充值限额  | body | false |integer(int64)  |    |
|channelId| 渠道id  | body | false |integer(int64)  |    |
|channelName| 渠道名称  | body | false |string  |    |
|chargeRatio| 兑换服务费比例  | body | false |integer(int32)  |    |
|pointExchangeRate| 被兑换积分汇率(RMB)  | body | false |integer(int32)  |    |
|pointName| 被兑换积分名称  | body | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 状态 下拉


**接口描述**:


**接口地址**:`/manage/thirdChannel/channelStates`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 分页 查询三方渠道


**接口描述**:


**接口地址**:`/manage/thirdChannel/selectChannels`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"channelDailyThreshold": 0,
			"channelDailyUserThreshold": 0,
			"channelId": 0,
			"channelKey": "",
			"channelName": "",
			"channelStatus": 0,
			"chargeRatio": 0,
			"createTime": 0,
			"lastOperatorId": 0,
			"logs": [
				{
					"channelId": 0,
					"createTime": 0,
					"id": 0,
					"operatorId": 0,
					"remark": "",
					"stateChange": ""
				}
			],
			"pointExchangeRate": 0,
			"pointName": ""
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 三方渠道表VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**三方渠道表VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|channelDailyThreshold | 日发放限额   |integer(int64)  |    |
|channelDailyUserThreshold | 用户日充值限额   |integer(int64)  |    |
|channelId | 渠道id   |integer(int64)  |    |
|channelKey | 渠道key   |string  |    |
|channelName | 渠道名称   |string  |    |
|channelStatus | 渠道状态   |integer(int32)  |    |
|chargeRatio | 兑换服务费比例   |integer(int32)  |    |
|createTime | 创建时间   |integer(int64)  |    |
|lastOperatorId | 最后操作人id   |integer(int64)  |    |
|logs | 创建时间   |array  | 三方渠道操作日志表VO   |
|pointExchangeRate | 被兑换积分汇率(RMB)   |integer(int32)  |    |
|pointName | 被兑换积分名称   |string  |    |

**三方渠道操作日志表VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|channelId | 渠道id   |integer(int64)  |    |
|createTime | 时间   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|operatorId | 操作人id   |integer(int64)  |    |
|remark | 备注   |string  |    |
|stateChange | 状态变更   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«三方渠道表VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 禁用 三方渠道


**接口描述**:


**接口地址**:`/manage/thirdChannel/updateToOffline/{channelId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelId| channelId  | path | true |integer  |    |
|remark| remark  | query | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 启用 三方渠道


**接口描述**:


**接口地址**:`/manage/thirdChannel/updateToOnline/{channelId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelId| channelId  | path | true |integer  |    |
|remark| remark  | query | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 应用管理 (管理端))
    

## 获取单个应用信息


**接口描述**:


**接口地址**:`/manage/application`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|appId| appId  | query | true |integer  |    |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json
{
	"appCode": "",
	"appId": 0,
	"appImg": "",
	"appName": "",
	"appStatus": 0,
	"appSubtitle": "",
	"appUrl": "",
	"lastOperatorId": 0,
	"logs": [
		{
			"applicationId": 0,
			"createTime": 0,
			"id": 0,
			"operatorId": 0,
			"remark": "",
			"stateChange": ""
		}
	],
	"sort": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|appCode| 应用code  |string  |    |
|appId| 应用id(主键)  |integer(int64)  | integer(int64)   |
|appImg| 应用图片  |string  |    |
|appName| 应用名称  |string  |    |
|appStatus| 状态  |integer(int32)  | integer(int32)   |
|appSubtitle| 应用副标题  |string  |    |
|appUrl| 应用启动链接  |string  |    |
|lastOperatorId| 最后操作人  |integer(int64)  | integer(int64)   |
|logs| 日志  |array  | VO   |
|sort| 排序字段  |integer(int32)  | integer(int32)   |



**schema属性说明**




**VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|applicationId | 应用id   |integer(int64)  |    |
|createTime | 时间   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|operatorId | 操作人id   |integer(int64)  |    |
|remark | 备注   |string  |    |
|stateChange | 状态变更   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |应用表VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 新增 应用


**接口描述**:


**接口地址**:`/manage/application`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"appCode": "",
	"appId": 0,
	"appImg": "",
	"appName": "",
	"appStatus": 0,
	"appSubtitle": "",
	"appUrl": "",
	"sort": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|applicationDTO| applicationDTO  | body | true |应用表DTO  | 应用表DTO   |
|authorization| token  | header | false |string  |    |

**schema属性说明**



**应用表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|appCode| 应用code  | body | false |string  |    |
|appId| 应用id(主键)  | body | false |integer(int64)  |    |
|appImg| 应用图片  | body | false |string  |    |
|appName| 应用名称  | body | false |string  |    |
|appStatus| 状态  | body | false |integer(int32)  |    |
|appSubtitle| 应用副标题  | body | false |string  |    |
|appUrl| 应用启动链接  | body | false |string  |    |
|sort| 排序字段  | body | false |integer(int32)  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 修改 应用


**接口描述**:


**接口地址**:`/manage/application`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"appCode": "",
	"appId": 0,
	"appImg": "",
	"appName": "",
	"appStatus": 0,
	"appSubtitle": "",
	"appUrl": "",
	"sort": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|applicationDTO| applicationDTO  | body | true |应用表DTO  | 应用表DTO   |
|authorization| token  | header | false |string  |    |

**schema属性说明**



**应用表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|appCode| 应用code  | body | false |string  |    |
|appId| 应用id(主键)  | body | false |integer(int64)  |    |
|appImg| 应用图片  | body | false |string  |    |
|appName| 应用名称  | body | false |string  |    |
|appStatus| 状态  | body | false |integer(int32)  |    |
|appSubtitle| 应用副标题  | body | false |string  |    |
|appUrl| 应用启动链接  | body | false |string  |    |
|sort| 排序字段  | body | false |integer(int32)  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 删除应用


**接口描述**:


**接口地址**:`/manage/application`


**请求方式**：`DELETE`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|appId| appId  | query | true |integer  |    |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 204 | No Content  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
## 分页 查询应用


**接口描述**:


**接口地址**:`/manage/application/selectApps`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"appCode": "",
			"appId": 0,
			"appImg": "",
			"appName": "",
			"appStatus": 0,
			"appSubtitle": "",
			"appUrl": "",
			"lastOperatorId": 0,
			"logs": [
				{
					"applicationId": 0,
					"createTime": 0,
					"id": 0,
					"operatorId": 0,
					"remark": "",
					"stateChange": ""
				}
			],
			"sort": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 应用表VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**应用表VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|appCode | 应用code   |string  |    |
|appId | 应用id(主键)   |integer(int64)  |    |
|appImg | 应用图片   |string  |    |
|appName | 应用名称   |string  |    |
|appStatus | 状态   |integer(int32)  |    |
|appSubtitle | 应用副标题   |string  |    |
|appUrl | 应用启动链接   |string  |    |
|lastOperatorId | 最后操作人   |integer(int64)  |    |
|logs | 日志   |array  | VO   |
|sort | 排序字段   |integer(int32)  |    |

**VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|applicationId | 应用id   |integer(int64)  |    |
|createTime | 时间   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|operatorId | 操作人id   |integer(int64)  |    |
|remark | 备注   |string  |    |
|stateChange | 状态变更   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«应用表VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 下架 应用


**接口描述**:


**接口地址**:`/manage/application/updateToOffline/{appId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|appId| appId  | path | true |integer  |    |
|authorization| token  | header | false |string  |    |
|remark| remark  | query | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 上架 应用


**接口描述**:


**接口地址**:`/manage/application/updateToOnline/{appId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|appId| appId  | path | true |integer  |    |
|authorization| token  | header | false |string  |    |
|remark| remark  | query | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 数据报表 (管理端))

## 抽佣面板


**接口描述**:


**接口地址**:`/manage/dailyStatistic/commissionData`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json
{
	"commissionRanking": [
		{
			"key": {},
			"value": {}
		}
	],
	"dailyCommissionData": [
		{
			"key": {},
			"value": {}
		}
	],
	"monthlyCommissionData": [
		{
			"key": {},
			"value": {}
		}
	],
	"weeklyCommissionData": [
		{
			"key": {},
			"value": {}
		}
	]
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|commissionRanking| 抽佣数据排行榜  |array  | KeyValue   |
|dailyCommissionData| 抽佣日数据  |array  | KeyValue   |
|monthlyCommissionData| 抽佣月数据  |array  | KeyValue   |
|weeklyCommissionData| 抽佣周数据  |array  | KeyValue   |



**schema属性说明**




**KeyValue**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|key |    |object  |    |
|value |    |object  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |抽佣面板VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 抽佣面板(根据时间区间查询按日数据)


**接口描述**:


**接口地址**:`/manage/dailyStatistic/commissionDataDaily`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
[
	{
		"key": {},
		"value": {}
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|key|   |object  |    |
|value|   |object  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |KeyValue|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 查询消耗数据面板


**接口描述**:


**接口地址**:`/manage/dailyStatistic/consumeBoardData`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|pointCode| 积分code  | query | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
{
	"commissionRanking": [
		{
			"key": {},
			"value": {}
		}
	],
	"consumeRanking": [
		{
			"key": {},
			"value": {}
		}
	],
	"dailyConsumeData": [
		{
			"key": {},
			"value": {}
		}
	],
	"monthlyConsumeData": [
		{
			"key": {},
			"value": {}
		}
	],
	"reExchangeRanking": [
		{
			"key": {},
			"value": {}
		}
	],
	"shoppingRanking": [
		{
			"key": {},
			"value": {}
		}
	],
	"weeklyConsumeData": [
		{
			"key": {},
			"value": {}
		}
	]
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|commissionRanking| 抽佣消耗排行榜  |array  | KeyValue   |
|consumeRanking| 消耗数据排行榜  |array  | KeyValue   |
|dailyConsumeData| 消耗日数据  |array  | KeyValue   |
|monthlyConsumeData| 消耗月数据  |array  | KeyValue   |
|reExchangeRanking| 回兑消耗排行榜  |array  | KeyValue   |
|shoppingRanking| 商品消耗排行榜  |array  | KeyValue   |
|weeklyConsumeData| 消耗周数据  |array  | KeyValue   |



**schema属性说明**




**KeyValue**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|key |    |object  |    |
|value |    |object  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |ConsumeBoardVO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 查询消耗数据面板(根据时间区间查询按日数据)


**接口描述**:


**接口地址**:`/manage/dailyStatistic/consumeBoardDataDaily`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|pointCode| 积分code  | query | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
[
	{
		"key": {},
		"value": {}
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|key|   |object  |    |
|value|   |object  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |KeyValue|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取数据报表聚合数据


**接口描述**:


**接口地址**:`/manage/dailyStatistic/data`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
{
	"beanConsume": 0,
	"beanIssueAmount": 0,
	"beanIssueCount": 0,
	"beanIssuePeople": 0,
	"commissionAmount": 0,
	"createTime": "",
	"dateTime": "",
	"exchangeFee": 0,
	"id": 0,
	"registerNum": 0,
	"valueCommission": 0,
	"valueConsume": 0,
	"valueIssueAmount": 0,
	"valueReExchange": 0,
	"valueShopping": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|beanConsume| 欢乐豆消耗额度  |integer(int64)  | integer(int64)   |
|beanIssueAmount| 转换欢乐豆额度  |integer(int64)  | integer(int64)   |
|beanIssueCount| 转换欢乐豆笔数  |integer(int32)  | integer(int32)   |
|beanIssuePeople| 转换欢乐豆人数  |integer(int32)  | integer(int32)   |
|commissionAmount| 抽佣额度统计  |integer(int64)  | integer(int64)   |
|createTime| 统计时间  |string(date-time)  | string(date-time)   |
|dateTime|   |string  |    |
|exchangeFee| 回兑服务费  |integer(int64)  | integer(int64)   |
|id| 主键  |integer(int64)  | integer(int64)   |
|registerNum| 注册人数  |integer(int32)  | integer(int32)   |
|valueCommission| 欢乐值抽佣  |integer(int64)  | integer(int64)   |
|valueConsume| 欢乐值消耗额度  |integer(int64)  | integer(int64)   |
|valueIssueAmount| 欢乐值转换额度  |integer(int64)  | integer(int64)   |
|valueReExchange| 欢乐值回兑  |integer(int64)  | integer(int64)   |
|valueShopping| 欢乐值购物消费  |integer(int64)  | integer(int64)   |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |每日统计VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 导出数据报表


**接口描述**:


**接口地址**:`/manage/dailyStatistic/export`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 服务费面板


**接口描述**:


**接口地址**:`/manage/dailyStatistic/feeData`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json
{
	"dailyFeeData": [
		{
			"key": {},
			"value": {}
		}
	],
	"feeRanking": [
		{
			"key": {},
			"value": {}
		}
	],
	"monthlyFeeData": [
		{
			"key": {},
			"value": {}
		}
	],
	"weeklyFeeData": [
		{
			"key": {},
			"value": {}
		}
	]
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|dailyFeeData| 服务费日数据  |array  | KeyValue   |
|feeRanking| 服务费排行榜  |array  | KeyValue   |
|monthlyFeeData| 服务费月数据  |array  | KeyValue   |
|weeklyFeeData| 服务费周数据  |array  | KeyValue   |



**schema属性说明**




**KeyValue**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|key |    |object  |    |
|value |    |object  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |服务费面板VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 服务费面板(根据时间区间查询按日数据)


**接口描述**:


**接口地址**:`/manage/dailyStatistic/feeDataDaily`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
[
	{
		"key": {},
		"value": {}
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|key|   |object  |    |
|value|   |object  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |KeyValue|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 查询发放数据面板


**接口描述**:


**接口地址**:`/manage/dailyStatistic/issueBoardData`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|pointCode| 积分code  | query | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
{
	"dailyIssueData": [
		{
			"key": {},
			"value": {}
		}
	],
	"issueRanking": [
		{
			"key": {},
			"value": {}
		}
	],
	"monthlyIssueData": [
		{
			"key": {},
			"value": {}
		}
	],
	"weeklyIssueData": [
		{
			"key": {},
			"value": {}
		}
	]
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|dailyIssueData| 发放日数据  |array  | KeyValue   |
|issueRanking| 发放数据排行榜  |array  | KeyValue   |
|monthlyIssueData| 发放月数据  |array  | KeyValue   |
|weeklyIssueData| 发放周数据  |array  | KeyValue   |



**schema属性说明**




**KeyValue**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|key |    |object  |    |
|value |    |object  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |IssueBoardVO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 查询发放数据面板(根据时间区间查询按日数据)


**接口描述**:


**接口地址**:`/manage/dailyStatistic/issueBoardDataDaily`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|pointCode| 积分code  | query | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
[
	{
		"key": {},
		"value": {}
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|key|   |object  |    |
|value|   |object  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |KeyValue|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取数据报表(分页)


**接口描述**:


**接口地址**:`/manage/dailyStatistic/pages`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"beanConsume": 0,
			"beanIssueAmount": 0,
			"beanIssueCount": 0,
			"beanIssuePeople": 0,
			"commissionAmount": 0,
			"createTime": "",
			"dateTime": "",
			"exchangeFee": 0,
			"id": 0,
			"registerNum": 0,
			"valueCommission": 0,
			"valueConsume": 0,
			"valueIssueAmount": 0,
			"valueReExchange": 0,
			"valueShopping": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 每日统计VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**每日统计VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|beanConsume | 欢乐豆消耗额度   |integer(int64)  |    |
|beanIssueAmount | 转换欢乐豆额度   |integer(int64)  |    |
|beanIssueCount | 转换欢乐豆笔数   |integer(int32)  |    |
|beanIssuePeople | 转换欢乐豆人数   |integer(int32)  |    |
|commissionAmount | 抽佣额度统计   |integer(int64)  |    |
|createTime | 统计时间   |string(date-time)  |    |
|dateTime |    |string  |    |
|exchangeFee | 回兑服务费   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|registerNum | 注册人数   |integer(int32)  |    |
|valueCommission | 欢乐值抽佣   |integer(int64)  |    |
|valueConsume | 欢乐值消耗额度   |integer(int64)  |    |
|valueIssueAmount | 欢乐值转换额度   |integer(int64)  |    |
|valueReExchange | 欢乐值回兑   |integer(int64)  |    |
|valueShopping | 欢乐值购物消费   |integer(int64)  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«每日统计VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 文件上传 (管理端))

## 上传


**接口描述**:


**接口地址**:`/manage/file/upload`


**请求方式**：`POST`


**consumes**:`["multipart/form-data"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|file| file  | formData | false |file  |    |

**响应示例**:

```json
{
	"str": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|str|   |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |StrResult|
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 渠道表 (管理端))

## 获取单个积分渠道信息


**接口描述**:


**接口地址**:`/manage/channel`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelId| channelId  | query | true |integer  |    |

**响应示例**:

```json
{
	"channelDailyThreshold": 0,
	"channelDailyUserThreshold": 0,
	"channelEndTime": 0,
	"channelId": 0,
	"channelKey": "",
	"channelName": "",
	"channelStartTime": 0,
	"channelStatus": 0,
	"closeThreshold": 0,
	"contactInfo": {},
	"createTime": 0,
	"logs": [
		{
			"createTime": 0,
			"id": 0,
			"operatorId": 0,
			"remark": "",
			"stateChange": ""
		}
	],
	"pointId": 0,
	"promptThreshold": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|channelDailyThreshold| 日发放限额  |integer(int64)  | integer(int64)   |
|channelDailyUserThreshold| 单用户日充值限额  |integer(int64)  | integer(int64)   |
|channelEndTime| 有效期结束时间  |integer(int64)  | integer(int64)   |
|channelId| 渠道id(主键)  |integer(int64)  | integer(int64)   |
|channelKey| 渠道key  |string  |    |
|channelName| 渠道名称  |string  |    |
|channelStartTime| 有效期开始时间  |integer(int64)  | integer(int64)   |
|channelStatus| 积分状态  |integer(int32)  | integer(int32)   |
|closeThreshold| 坏账关闭阈值  |integer(int64)  | integer(int64)   |
|contactInfo| 联系人信息map  |object  |    |
|createTime| 创建时间  |integer(int64)  | integer(int64)   |
|logs| 日志信息  |array  | 渠道操作日志表VO   |
|pointId| 积分主键  |integer(int64)  | integer(int64)   |
|promptThreshold| 坏账提醒阈值  |integer(int64)  | integer(int64)   |



**schema属性说明**




**渠道操作日志表VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|createTime | 时间   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|operatorId | 操作人id   |integer(int64)  |    |
|remark | 备注   |string  |    |
|stateChange | 状态变更   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |渠道表VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 新增 积分渠道


**接口描述**:


**接口地址**:`/manage/channel`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"channelDailyThreshold": 0,
	"channelDailyUserThreshold": 0,
	"channelEndTime": 0,
	"channelId": 0,
	"channelName": "",
	"channelStartTime": 0,
	"closeThreshold": 0,
	"contactInfo": "",
	"pointId": 0,
	"promptThreshold": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelDTO| channelDTO  | body | true |渠道表DTO  | 渠道表DTO   |

**schema属性说明**



**渠道表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|channelDailyThreshold| 日发放限额  | body | false |integer(int64)  |    |
|channelDailyUserThreshold| 单用户日充值限额  | body | false |integer(int64)  |    |
|channelEndTime| 有效期结束时间  | body | false |integer(int64)  |    |
|channelId| 渠道id(主键)  | body | false |integer(int64)  |    |
|channelName| 渠道名称  | body | false |string  |    |
|channelStartTime| 有效期开始时间  | body | false |integer(int64)  |    |
|closeThreshold| 坏账关闭阈值  | body | false |integer(int64)  |    |
|contactInfo| 联系人信息map  | body | false |string  |    |
|pointId| 积分主键  | body | false |integer(int64)  |    |
|promptThreshold| 坏账提醒阈值  | body | false |integer(int64)  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 修改 积分渠道


**接口描述**:


**接口地址**:`/manage/channel`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"channelDailyThreshold": 0,
	"channelDailyUserThreshold": 0,
	"channelEndTime": 0,
	"channelId": 0,
	"channelName": "",
	"channelStartTime": 0,
	"closeThreshold": 0,
	"contactInfo": "",
	"pointId": 0,
	"promptThreshold": 0
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelDTO| channelDTO  | body | true |渠道表DTO  | 渠道表DTO   |

**schema属性说明**



**渠道表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|channelDailyThreshold| 日发放限额  | body | false |integer(int64)  |    |
|channelDailyUserThreshold| 单用户日充值限额  | body | false |integer(int64)  |    |
|channelEndTime| 有效期结束时间  | body | false |integer(int64)  |    |
|channelId| 渠道id(主键)  | body | false |integer(int64)  |    |
|channelName| 渠道名称  | body | false |string  |    |
|channelStartTime| 有效期开始时间  | body | false |integer(int64)  |    |
|closeThreshold| 坏账关闭阈值  | body | false |integer(int64)  |    |
|contactInfo| 联系人信息map  | body | false |string  |    |
|pointId| 积分主键  | body | false |integer(int64)  |    |
|promptThreshold| 坏账提醒阈值  | body | false |integer(int64)  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 状态 下拉


**接口描述**:


**接口地址**:`/manage/channel/channelStates`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取积分选择下拉


**接口描述**:


**接口地址**:`/manage/channel/points`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |

**响应示例**:

```json
[
	{
		"createTime": 0,
		"pointCode": "",
		"pointExchangeRate": 0,
		"pointId": 0,
		"pointName": ""
	}
]
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|createTime| 创建时间  |integer(int64)  | integer(int64)   |
|pointCode| 积分code  |string  |    |
|pointExchangeRate| 积分汇率(RMB)  |integer(int32)  | integer(int32)   |
|pointId|  积分表主键  |integer(int64)  | integer(int64)   |
|pointName| 积分名称  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |积分表VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 分页 查询渠道


**接口描述**:


**接口地址**:`/manage/channel/selectChannels`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"channelDailyThreshold": 0,
			"channelDailyUserThreshold": 0,
			"channelEndTime": 0,
			"channelId": 0,
			"channelKey": "",
			"channelName": "",
			"channelStartTime": 0,
			"channelStatus": 0,
			"closeThreshold": 0,
			"createTime": 0,
			"logs": [
				{
					"createTime": 0,
					"id": 0,
					"operatorId": 0,
					"remark": "",
					"stateChange": ""
				}
			],
			"pointId": 0,
			"promptThreshold": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 渠道表ListVO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**渠道表ListVO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|channelDailyThreshold | 日发放限额   |integer(int64)  |    |
|channelDailyUserThreshold | 单用户日充值限额   |integer(int64)  |    |
|channelEndTime | 有效期结束时间   |integer(int64)  |    |
|channelId | 渠道id(主键)   |integer(int64)  |    |
|channelKey | 渠道key   |string  |    |
|channelName | 渠道名称   |string  |    |
|channelStartTime | 有效期开始时间   |integer(int64)  |    |
|channelStatus | 积分状态   |integer(int32)  |    |
|closeThreshold | 坏账关闭阈值   |integer(int64)  |    |
|createTime | 创建时间   |integer(int64)  |    |
|logs | 日志信息   |array  | 渠道操作日志表VO   |
|pointId | 积分主键   |integer(int64)  |    |
|promptThreshold | 坏账提醒阈值   |integer(int64)  |    |

**渠道操作日志表VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|createTime | 时间   |integer(int64)  |    |
|id | 主键   |integer(int64)  |    |
|operatorId | 操作人id   |integer(int64)  |    |
|remark | 备注   |string  |    |
|stateChange | 状态变更   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«渠道表ListVO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 禁用 积分渠道


**接口描述**:


**接口地址**:`/manage/channel/updateToOffline/{channelId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelId| channelId  | path | true |integer  |    |
|remark| remark  | query | true |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 启用 积分渠道


**接口描述**:


**接口地址**:`/manage/channel/updateToOnline/{channelId}`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|channelId| channelId  | path | true |integer  |    |
|remark| remark  | query | true |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 积分表 (管理端))

## 查询积分


**接口描述**:


**接口地址**:`/manage/point`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|pointId| pointId  | query | true |integer  |    |

**响应示例**:

```json
{
	"createTime": 0,
	"pointCode": "",
	"pointExchangeRate": 0,
	"pointId": 0,
	"pointName": ""
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|createTime| 创建时间  |integer(int64)  | integer(int64)   |
|pointCode| 积分code  |string  |    |
|pointExchangeRate| 积分汇率(RMB)  |integer(int32)  | integer(int32)   |
|pointId|  积分表主键  |integer(int64)  | integer(int64)   |
|pointName| 积分名称  |string  |    |





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |积分表VO|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 新增积分


**接口描述**:


**接口地址**:`/manage/point`


**请求方式**：`POST`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"pointCode": "",
	"pointExchangeRate": 0,
	"pointId": 0,
	"pointName": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|pointDTO| pointDTO  | body | true |积分表DTO  | 积分表DTO   |

**schema属性说明**



**积分表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|pointCode| 积分code  | body | false |string  |    |
|pointExchangeRate| 积分汇率(RMB)  | body | false |integer(int32)  |    |
|pointId|  积分表主键  | body | false |integer(int64)  |    |
|pointName| 积分名称  | body | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 修改积分


**接口描述**:


**接口地址**:`/manage/point`


**请求方式**：`PUT`


**consumes**:`["application/json"]`


**produces**:`["*/*"]`


**请求示例**：
```json
{
	"pointCode": "",
	"pointExchangeRate": 0,
	"pointId": 0,
	"pointName": ""
}
```


**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|pointDTO| pointDTO  | body | true |积分表DTO  | 积分表DTO   |

**schema属性说明**



**积分表DTO**

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|pointCode| 积分code  | body | false |string  |    |
|pointExchangeRate| 积分汇率(RMB)  | body | false |integer(int32)  |    |
|pointId|  积分表主键  | body | false |integer(int64)  |    |
|pointName| 积分名称  | body | false |string  |    |

**响应示例**:

```json

```

**响应参数**:


暂无





**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  ||
| 201 | Created  ||
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 分页积分列表


**接口描述**:


**接口地址**:`/manage/point/points`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"createTime": 0,
			"pointCode": "",
			"pointExchangeRate": 0,
			"pointId": 0,
			"pointName": ""
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 积分表VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**积分表VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|createTime | 创建时间   |integer(int64)  |    |
|pointCode | 积分code   |string  |    |
|pointExchangeRate | 积分汇率(RMB)   |integer(int32)  |    |
|pointId |  积分表主键   |integer(int64)  |    |
|pointName | 积分名称   |string  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«积分表VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
# 记录管理 (管理端))

## 获取发放渠道记录


**接口描述**:


**接口地址**:`/manage/userPointBill/channelRecords`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|billType| 类型  | query | false |integer  |    |
|channelName| 渠道名称  | query | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"billId": 0,
			"billType": 0,
			"channelChangedPoints": 0,
			"channelId": 0,
			"channelName": "",
			"createTime": "",
			"pointId": 0,
			"relationId": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 渠道记录VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**渠道记录VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|billId | 账单主键   |integer(int64)  |    |
|billType | 账单类型   |integer(int32)  |    |
|channelChangedPoints | 渠道变动积分数   |integer(int64)  |    |
|channelId | 渠道id   |integer(int64)  |    |
|channelName | 渠道名称   |string  |    |
|createTime | 创建时间   |string(date-time)  |    |
|pointId | 积分主键   |integer(int64)  |    |
|relationId | 关联id   |integer(int64)  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«渠道记录VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取抽佣记录


**接口描述**:


**接口地址**:`/manage/userPointBill/commissionRecords`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|appName| 应用名称  | query | false |string  |    |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"appName": "",
			"billId": 0,
			"commissionRatio": 0,
			"createTime": "",
			"relationId": 0,
			"userWinedPoints": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 抽佣记录VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**抽佣记录VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|appName | 应用名称   |string  |    |
|billId | 账单主键   |integer(int64)  |    |
|commissionRatio | 抽佣比例   |integer(int32)  |    |
|createTime | 创建时间   |string(date-time)  |    |
|relationId | 关联id   |integer(int64)  |    |
|userWinedPoints | 获胜积分   |integer(int64)  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«抽佣记录VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取积分记录


**接口描述**:


**接口地址**:`/manage/userPointBill/pointRecords`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|billType| 类型1-支出 2-收入  | query | false |integer  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|firstChargeMark| 首充筛选:0-非首充 1-首充  | query | false |integer  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |
|pointCode| 积分code  | query | false |string  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |
|userId| 用户主键  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"appName": "",
			"billId": 0,
			"billType": 0,
			"changeReason": "",
			"createTime": "",
			"firstChargeMark": 0,
			"pointId": 0,
			"relationId": 0,
			"userChangedPoints": 0,
			"userEndPoints": 0,
			"userId": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 积分记录VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**积分记录VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|appName | 应用名称   |string  |    |
|billId | 账单主键   |integer(int64)  |    |
|billType | 关联类型   |integer(int32)  |    |
|changeReason | 变更原因   |string  |    |
|createTime | 生成时间   |string(date-time)  |    |
|firstChargeMark | 首充标记   |integer(int32)  |    |
|pointId | 积分主键   |integer(int64)  |    |
|relationId | 关联id   |integer(int64)  |    |
|userChangedPoints | 用户变动积分   |integer(int64)  |    |
|userEndPoints | 用户变动后积分   |integer(int64)  |    |
|userId | 用户id   |integer(int64)  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«积分记录VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
## 获取回兑记录


**接口描述**:


**接口地址**:`/manage/userPointBill/reExchangeRecords`


**请求方式**：`GET`


**consumes**:``


**produces**:`["*/*"]`



**请求参数**：

| 参数名称         | 参数说明     |     in |  是否必须      |  数据类型  |  schema  |
| ------------ | -------------------------------- |-----------|--------|----|--- |
|authorization| token  | header | false |string  |    |
|count| 是否计算总数  | query | false |boolean  |    |
|pageIndex| 第几页  | query | false |integer  |    |
|pageSize| 每页大小  | query | false |integer  |    |
|queryEndTimeStamp| 查询结束时间  | query | false |integer  |    |
|queryStartTimeStamp| 查询开始时间  | query | false |integer  |    |
|targetPointName| 应用名称  | query | false |string  |    |
|userId| 用户主键  | query | false |integer  |    |

**响应示例**:

```json
{
	"pageNum": 0,
	"pageSize": 0,
	"pages": 0,
	"rows": [
		{
			"billId": 0,
			"commission": 0,
			"createTime": "",
			"feeRatio": 0,
			"pointId": 0,
			"relationId": 0,
			"targetPointChanged": 0,
			"targetPointName": "",
			"userChangedPoints": 0,
			"userId": 0
		}
	],
	"total": 0
}
```

**响应参数**:


| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | -------------------|-------|----------- |
|pageNum|   |integer(int32)  | integer(int32)   |
|pageSize|   |integer(int32)  | integer(int32)   |
|pages|   |integer(int32)  | integer(int32)   |
|rows|   |array  | 回兑记录VO   |
|total|   |integer(int64)  | integer(int64)   |



**schema属性说明**




**回兑记录VO**

| 参数名称         | 参数说明                             |    类型 |  schema |
| ------------ | ------------------|--------|----------- |
|billId | 账单主键   |integer(int64)  |    |
|commission | 佣金   |integer(int64)  |    |
|createTime | 创建时间   |string(date-time)  |    |
|feeRatio | 服务费比例   |integer(int32)  |    |
|pointId | 积分主键   |integer(int64)  |    |
|relationId | 关联id   |integer(int64)  |    |
|targetPointChanged | 回兑额度   |integer(int64)  |    |
|targetPointName | 被兑积分名称   |string  |    |
|userChangedPoints | 消耗积分   |integer(int64)  |    |
|userId | 用户id   |integer(int64)  |    |

**响应状态**:


| 状态码         | 说明                            |    schema                         |
| ------------ | -------------------------------- |---------------------- |
| 200 | OK  |PagerList«回兑记录VO»|
| 401 | Unauthorized  ||
| 403 | Forbidden  ||
| 404 | Not Found  ||
