# HDDK

活动大咖，校园活动发布管理程序分析设计与实现

---

## 数据库表设计

学生表 Student：

|名|类型|长度|允许空|是否主键|备注|
|---|---|---|---|---|---|
|s_id|bigint|20|×|√|学生id|
|s_name|varchar|12|×|×|姓名|
|class_id|int|11|×|×|班级id|

班级表 Classes：

|名|类型|长度|允许空|是否主键|备注|
|---|---|---|---|---|---|
|c_id|int|11|×|√|班级id|
|c_name|varchar|12|×|×|班级名|

场地表 Field：

|名|类型|长度|允许空|是否主键|备注|
|---|---|---|---|---|---|
|f_id|int|11|×|√|场地id|
|f_info|varchar|20|×|×|场地信息|
|signUpNumLimit|int|11|×|×|报名人数上限|
|t_tel|varchar|11|√|×|电话|
|t_name|varchar|12|×|×|负责教师姓名|
|a_id|int|11|√|×|活动id|

活动表 Activity：

|名|类型|长度|允许空|是否主键|备注|
|---|---|---|---|---|---|
|a_id|int|11|×|√|活动id|
|theme|varchar|15|×|×|活动主题|
|score|double|6|×|×|思政分|
|description|varchar|255|×|×|活动描述|
|tips|varchar|100|√|×|注意事项|
|releaseState|int|1|×|×|发布方式：0直接发布；1定时发布|
|releaseTime|date|0|×|×|活动发布时间|
|needStuSignUp|int|1|√|×|需要学生报名？0否；1是|
|signUpStartTime|date|0|×|×|报名开始时间|
|signUpEndTime|date|0|×|×|报名结束时间|
|startTime|date|0|×|×|活动开始时间|
|endTime|date|0|×|×|活动结束时间|
|signInTimes|int|10|√|×|签到次数|
|signInState|int|1|×|×|签到状态：0未开始；1正在签到|
|a_state|int|1|×|×|活动状态：0草稿；1未开始；2报名中；3进行中；4结束|
|fields|varchar|255|×|×|活动场地：字符串存储场地id|

记录表 Sign：

|名|类型|长度|允许空|是否主键|备注|
|---|---|---|---|---|---|
|id|bigint|20|×|√|记录表id|
|signState|int|1|×|×|签到状态：0报名；1过审；2签到|
|signTime|date|0|√|×|签到时间|
|activity_id|int|11|√|×|活动id|
|student_id|bigint|20|√|×|学生id|
|personState|int|1|√|×|是否为签到负责人？0否；1是|

---

## 原形设计
[https://modao.cc/app/O3zcb8WxqciXEgWPfUs9VDnoXmACy15](https://modao.cc/app/O3zcb8WxqciXEgWPfUs9VDnoXmACy15)

##接口

---

**1\. 查询所有活动信息**
###### 接口功能
> 获取所有活动信息

###### URL
> [http://101.200.32.54:8080/NetHDDK-1.0/teacher/getAllActivity](http://101.200.32.54:8080/NetHDDK-1.0/teacher/getAllActivity)

###### 支持格式
> JSON

###### HTTP请求方式
> POST

###### 请求参数 无

###### 返回字段

|返回字段|字段类型|说明|
|---|---|---|
|ErrorCode|String|返回结果状态。0：正常；其他：错误。|
|Message|string|返回结果信息|
|Data|string|返回activity对象集合|

---

###### 接口示例
> 地址：[http://101.200.32.54:8080/NetHDDK-1.0/teacher/getAllActivity](http://101.200.32.54:8080/NetHDDK-1.0/teacher/getAllActivity)
``` javascript
{
    "ErrorCode": "0",
    "Message": "执行成功!",
    "Data": [
        {
            "a_id": 1,
            "theme": "coding",
            "signUpStartTime": "2018-09-25",
            "startTime": "2018-09-25",
            "a_state": 0,
            "num": 2
        },
        {
            "a_id": 2,
            "theme": "english",
            "signUpStartTime": "2018-09-26",
            "startTime": "2018-09-26",
            "a_state": 1,
            "num": 1
        },
        {
            "a_id": 3,
            "theme": "business",
            "signUpStartTime": "2018-09-25",
            "startTime": "2018-09-25",
            "a_state": 2,
            "num": 1
        }
    ]
}
