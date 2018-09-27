import Mock from 'mockjs'

const random = Mock.Random;

let activities = [];

for (let i = 0; i < 10; i++) {
    let activity = {
        id: (i+1),
        title: random.ctitle(4, 10),
        status: '报名中',
        time: random.date('yyyy-MM-dd'),
        personLimit: random.integer(50, 500),
        signUpNumber: random.integer(50, 500),
        description: random.cparagraph(6, 30)
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