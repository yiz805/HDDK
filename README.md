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
|describe|varchar|255|×|×|活动描述|
|tips|varchar|100|√|×|注意事项|
|releaseState|int|1|×|×|发布方式：0直接发布；1定时发布|
|releaseTime|date|0|×|×|活动发布时间|
|needStuSignUp|int|1|√|×|需要学生报名？0否；1是|
|signUpStartTime|date|0|×|×|报名开始时间|
|signUpEndTime|date|0|×|×|报名结束时间|
|startTime|date|0|×|×|活动开始时间|
|endTime|date|0|×|×|活动结束时间|
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