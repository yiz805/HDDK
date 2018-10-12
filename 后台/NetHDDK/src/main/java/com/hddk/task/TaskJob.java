package com.hddk.task;

import com.hddk.QueryVo.ActivityQueryVo_task;
import com.hddk.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class TaskJob {
    @Autowired
    private ActivityService activityService;

    @Scheduled(cron = "0 */3 * * * ?")
    public void taskDo() {
        Date now = new Date();
        System.out.println("-----------定时任务-----------" + now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        List<ActivityQueryVo_task> times = activityService.getTimes();
        try {
            for (int i = 0; i < times.size(); i++) {
                int a_state = times.get(i).getA_state();
                //未发布,0->1,发布
                if (a_state == 0) {
                    String time = times.get(i).getReleaseTime();
                    Date releaseTime = sdf.parse(time);
                    if (now.after(releaseTime)) {
                        int a_id = times.get(i).getA_id();
                        activityService.releaseActivity(a_id);
                        System.out.println("---------发布-----------" + times.get(i).getA_id());
                    }
                }
                //发布,1->2,报名
                if (a_state == 1) {
                    String time = times.get(i).getSignUpStartTime();
                    Date signUpStartTime = sdf.parse(time);
                    if (now.after(signUpStartTime)) {
                        int a_id = times.get(i).getA_id();
                        activityService.startSignUp(a_id);
                        System.out.println("---------报名-----------" + times.get(i).getA_id());
                    }
                }
                //报名,2->3,报名结束
                if (a_state == 2) {
                    String time = times.get(i).getSignUpEndTime();
                    Date signUpEndTime = sdf.parse(time);
                    if (now.after(signUpEndTime)) {
                        int a_id = times.get(i).getA_id();
                        activityService.endSignUp(a_id);
                        System.out.println("--------报名结束-----------" + times.get(i).getA_id());
                    }
                }
                //报名结束,3->4,正在进行
                if (a_state == 3) {
                    String time = times.get(i).getStartTime();
                    Date startTime = sdf.parse(time);
                    if (now.after(startTime)) {
                        int a_id = times.get(i).getA_id();
                        activityService.startActivity(a_id);
                        System.out.println("---------正在进行-----------" + times.get(i).getA_id());
                    }
                }
                //正在进行,4->5,结束
                if (a_state == 4) {
                    String time = times.get(i).getEndTime();
                    Date endTime = sdf.parse(time);
                    if (now.after(endTime)) {
                        int a_id = times.get(i).getA_id();
                        activityService.endActivity(a_id);
                        System.out.println("---------结束-----------" + times.get(i).getA_id());
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
