## 上传ip
- url：/ip/upload
- 说明：会保存在内存里，服务重启后请重新上传。
- 参数：

字段 | 类型|是否必须 | 示例 | 备注
---|---|---|---|---
ip | String | true | 10.25.13.0,10.25.13.1,10.25.13.2 | 多个ip用英文逗号分割
- 返回data字段：

类型 | 示例 | 备注
---|---|---
String | 10.25.13.0,10.25.13.1,10.25.13.2 | 多个ip用英文逗号分割

## 获取ip
- url：/ip/get
- 参数：无
- 返回data字段：

类型 | 示例 | 备注
---|---|---
String | 10.25.13.0,10.25.13.1,10.25.13.2 | 多个ip用英文逗号分割


## 获取设备信息
- url：/device/get
- 参数：

字段 | 类型|是否必须 | 示例 | 备注
---|---|---|---|---
position | int | true | 1000 | 起始id，若超过最大值，则会返回错误
num | int | true | 50 | 顺序返回的结果数量

- 返回data字段为JSONArray，其中JSONObject结构如下：

字段 | 类型 | 示例 | 备注
---|---|---|---
id | String |1012 | 对应的id
info | String | {"_id":{"$oid":"58d13ae58233af48a7c9fa75"},"osVersion":"5.1.1"} | 

## 获取所有任务
- url：/task
- 参数：无
- 返回data字段为Task的List

## 新建任务
- url：/task/add
- 参数：

字段 | 类型|是否必须 | 示例 | 备注
---|---|---|---|---
appId | String | true | 3543 | 
appName | String | true | 50 | 
totalNumber | int | true | 10000 | 总量
numberPerDay | int | true | 2500 | 每天的量
initialNumber | int | true | 500 | 初始化数量

- 返回data字段，即task对象

## 删除任务
- url：/task/delete
- 参数：
 
字段 | 类型|是否必须 | 示例 | 备注
---|---|---|---|---
appId | String | true | 3543 | 
- 返回data字段

## 暂停任务
- url：/task/pause
- 说明：把status字段更新为5
- 参数：

字段 | 类型|是否必须 | 示例 | 备注
---|---|---|---|---
appId | String | true | 3543 | 
- 返回data字段

## 打点
- url：/task/dot
- 说明：对指定appId进行打点，记录每次加1
- 参数：

字段 | 类型|是否必须 | 示例 | 备注
---|---|---|---|---
appId | String | true | 3543 | 
- 返回data字段


## 打点列表
- url：/task/dot/list
- 参数：无
- 返回data字段为TaskDotRecord的List，其中TaskDotRecord的字段：

字段 | 类型 | 示例 | 备注
---|---|---|---
appId | String | 3543 | 
date | String | 2018-06-28 | 日期
dotCount | int | 2 | 

