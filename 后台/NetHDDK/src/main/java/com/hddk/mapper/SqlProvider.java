package com.hddk.mapper;

import com.hddk.entity.Activity;
import com.hddk.entity.Field;
import com.hddk.entity.Sign;
import jdk.nashorn.internal.objects.annotations.Where;
import org.apache.ibatis.jdbc.SQL;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SqlProvider {
    private final String activity_TABLE = "activity";
    private final String field_TABLE = "field";
    private final String sign_TABLE = "sign";

    //添加活动
    public String INSET_Activity(final Activity activity) {
        return new SQL() {
            {
                INSERT_INTO(activity_TABLE);
                if (activity.getTheme() != null)
                    VALUES("theme", "#{theme}");
                if (activity.getTips() != null)
                    VALUES("tips", "#{tips}");
                if (activity.getDescription() != null)
                    VALUES("description", "#{description}");
                if (activity.getReleaseState() != null)
                    VALUES("releaseState", "#{releaseState}");
                if (activity.getReleaseTime() != null)
                    VALUES("releaseTime", "#{releaseTime}");
                if (activity.getA_state() != null)
                    VALUES("a_state", "#{a_state}");
                if (activity.getScore() != null)
                    VALUES("score", "#{score}");
                if (activity.getSignUpStartTime() != null)
                    VALUES("signUpStartTime", "#{signUpStartTime}");
                if (activity.getSignUpEndTime() != null)
                    VALUES("signUpEndTime", "#{signUpEndTime}");
                if (activity.getStartTime() != null)
                    VALUES("startTime", "#{startTime}");
                if (activity.getEndTime() != null)
                    VALUES("endTime", "#{endTime}");
                if (activity.getSignInTimes() != null)
                    VALUES("signInTimes", "#{signInTimes}");
                if (activity.getSignInState() != null)
                    VALUES("signInState", "#{signInState}");
            }
        }.toString();
    }

    //修改活动
    public String UPDATE_Activity(final Activity activity) {
        return new SQL() {
            {
                UPDATE(activity_TABLE);
                if (activity.getTheme() != null)
                    SET("theme=#{theme}");
                if (activity.getTips() != null)
                    SET("tips=#{tips}");
                if (activity.getTips() != null)
                    SET("description=#{description}");
                if (activity.getTips() != null)
                    SET("releaseState=#{releaseState}");
                if (activity.getTips() != null)
                    SET("releaseTime=#{releaseTime}");
                if (activity.getTips() != null)
                    SET("a_state=#{a_state}");
                if (activity.getTips() != null)
                    SET("score=#{score}");
                if (activity.getTips() != null)
                    SET("signUpStartTime=#{signUpStartTime}");
                if (activity.getTips() != null)
                    SET("signUpEndTime=#{signUpEndTime}");
                if (activity.getTips() != null)
                    SET("startTime=#{startTime}");
                if (activity.getTips() != null)
                    SET("endTime=#{endTime}");
                if (activity.getTips() != null)
                    SET("signInTimes=#{signInTimes}");
                if (activity.getTips() != null)
                    SET("signInState=#{signInState}");

                WHERE("a_id=#{a_id}");
            }
        }.toString();
    }

    //添加场地
    public String INSERT_Field(final Field field) {
        return new SQL() {
            {
                INSERT_INTO(field_TABLE);
                if (field.getF_info() != null)
                    VALUES("f_info", "#{f_info}");
                if (field.getSignUpNumLimit() != null)
                    VALUES("signUpNumLimit", "#{signUpNumLimit}");
                if (field.getT_name() != null)
                    VALUES("t_name", "#{t_name}");
                if (field.getT_tel() != null)
                    VALUES("t_tel", "#{t_tel}");
                if (field.getActivity_id() != null)
                    VALUES("activity_id", "#{activity_id}");

            }
        }.toString();
    }

    //修改场地
    public String UPDATE_Field(final Field field) {
        return new SQL() {
            {
                UPDATE(field_TABLE);
                if (field.getF_info() != null)
                    SET("f_info=#{f_info}");
                if (field.getSignUpNumLimit() != null)
                    SET("signUpNumLimit=#{signUpNumLimit}");
                if (field.getT_name() != null)
                    SET("t_name=#{t_name}");
                if (field.getT_tel() != null)
                    SET("t_tel=#{t_tel}");
                WHERE("f_id=#{f_id}");
            }
        }.toString();
    }

    //添加记录
    public String INSERT_Sign(final Sign sign) {
        return new SQL() {
            {
                INSERT_INTO(sign_TABLE);
                if (sign.getSignState() != null)
                    VALUES("signState", "#{signState}");
                if (sign.getSignTime() != null)
                    VALUES("signTime", "#{signTime}");
                if (sign.getActivity() != null)
                    VALUES("activity_id", "#{activity.a_id}");
                if (sign.getStudent() != null)
                    VALUES("student_id", "#{student.s_id}");
                if (sign.getField() != null)
                    VALUES("field_id", "#{field.f_id}");
                if (sign.getPersonState() != null)
                    VALUES("personState", "#{personState}");
            }
        }.toString();
    }

    //模糊查询
    public String GET_ACTIVITY_BY_CONDITION(Map<String, Object> param) {
        String sql = "SELECT a.a_id,a.theme,a.signUpStartTime,a.startTime,a.a_state,count(s.activity_id) num from (select a_id,theme,signUpStartTime,startTime,a_state,releaseTime from activity ";
        if (param.get("0").equals(0)) {//0:按主题
            sql += "WHERE theme LIKE '%" + param.get("content").toString() + "%'";
        }
        if(param.get("0").equals(1)){//按时间范围
            String time[] = param.get("content").toString().split(",");
            String start = time[0];//开始时间
            String end = time[1];//结束时间
            System.out.println(start + end);
            if (start != null && !start.equals(" ")) {
                sql += "WHERE startTime>='" + start + "' ";
                if (end != null && !end.equals(" ")) {
                    sql += "AND endTime<='" + end + "'";
                }
            } else {
                if (end != null && !end.equals(" ")) {
                    sql += "WHERE endTime<='" + end + "'";
                }
            }
        }
        if(param.get("0").equals(2)){//按状态
            if (!param.get("content").equals("6")) {
                int state = Integer.parseInt(param.get("content").toString());
                if (!param.get("content").equals("")) {
                    sql += "WHERE a_state=" + state;
                }
            }
        }
        sql += ") a left join (select activity_id from sign ) s on a.a_id = s.activity_id GROUP BY a.a_id ORDER BY a.releaseTime DESC LIMIT #{page},7";
        return sql;
    }
}
