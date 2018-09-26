<template>
    <div id="activity-list-page">
        <Scroll @scroll="scroll" class="wrapper">
            <div class="content">
                <ActivityListItem v-for="activity in activities" :key="activity.id" :activity="activity" @click.native="openActivityDetails(activity)"/>
            </div>
        </Scroll>
    </div>
</template>

<script>
    import ActivityListItem from '../components/ActivityListItem/ActivityListItem'
    import Scroll from '../components/Scroll'

    export default {
        name: "ActivityList",
        components: {
            ActivityListItem,
            Scroll
        },
        data() {
            return {
                activities: [
                    {
                        id: 1,
                        title: '测试活动一',
                        status: '报名中',
                        time: '2018.09.26',
                        personLimit: 300,
                        signUpNumber: 175
                    },
                    {
                        id: 2,
                        title: '测试活动二',
                        status: '报名中',
                        time: '2018.09.26',
                        personLimit: 300,
                        signUpNumber: 24
                    },
                    {
                        id: 3,
                        title: '测试活动三',
                        status: '报名中',
                        time: '2018.09.26',
                        personLimit: 300,
                        signUpNumber: 289
                    },
                    {
                        id: 4,
                        title: '测试活动三',
                        status: '报名中',
                        time: '2018.09.26',
                        personLimit: 300,
                        signUpNumber: 289
                    },
                    {
                        id: 5,
                        title: '测试活动三',
                        status: '报名中',
                        time: '2018.09.26',
                        personLimit: 300,
                        signUpNumber: 289
                    },
                    {
                        id: 6,
                        title: '测试活动三',
                        status: '报名中',
                        time: '2018.09.26',
                        personLimit: 300,
                        signUpNumber: 289
                    }
                ],
                scrollY: 0
            }
        },
        methods: {
            openActivityDetails: (activity) => {

            },
            scroll(pos) {
                this.scrollY = pos.y
            }
        }
    }
</script>

<style scoped lang="stylus">
    .wrapper {
        height: calc(100vh - 110px);
        overflow hidden

        .content {
            padding-top: 20px;
            overflow auto
        }
    }
</style>