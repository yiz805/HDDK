import Mock from 'mockjs'

const random = Mock.Random;

let activities = [];

for (let i = 0; i < 10; i++) {
    let activity = {
        id: (i+1),
        title: random.ctitle(4, 10),
        status: '报名中',
        startTime: random.date('yyyy-MM-dd'),
        signUpStartTime: random.date('yyyy-MM-dd'),
        personLimit: random.integer(300, 500),
        signUpNumber: random.integer(50, 500),
        description: random.cparagraph(6, 100),
        score: random.integer(1, 10),
        tips: random.cparagraph(10, 100)
    };

    activities.push(activity);
}

const getActivities = function () {
    return {
        activities: activities
    }
};

const getActivity = function () {
    return {
        activity: activities[1]
    }
}

Mock.mock('/api/activities', 'get', getActivities);
Mock.mock('/api/activity/1', 'get', getActivity);