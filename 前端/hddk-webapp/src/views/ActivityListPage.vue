<template>
    <div id="activity-list-page">
        <Scroll @scroll="scroll" class="wrapper" :data="activities">
            <div class="content">
                <ActivityListItem v-for="activity in activities" :key="activity.id" :activity="activity" @item-click="openActivityDetails(activity)"/>
            </div>
        </Scroll>

        <transition name="slide-up">
            <router-view />
        </transition>
    </div>
</template>

<script>
    import ActivityListItem from '../components/ActivityListItem/ActivityListItem'

    export default {
        name: "ActivityList",
        components: {
            ActivityListItem
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
                        signUpNumber: 175,
                        description: "这是一个测试活动来着，每一个活动都会有一个活动简介",
                        fields:[]
                    }
                ],
                scrollY: 0
            }
        },
        methods: {
            openActivityDetails() {
                this.$router.push({name: "activity", params: {id: '1'}})
            },
            scroll(pos) {
                this.scrollY = pos.y
            },
            getActivities() {
                this.$http.get('/api/activities').then((res) => {
                    this.activities = res.data.activities
                });
            }
        },
        mounted() {
            this.getActivities();
        }
    }
</script>

<style scoped lang="stylus">
    @import "../assets/stylus/animation.styl"

    .wrapper {
        height: calc(100vh - 110px);
        overflow hidden

        .content {
            padding-top: 20px;
            overflow auto
        }
    }
</style>