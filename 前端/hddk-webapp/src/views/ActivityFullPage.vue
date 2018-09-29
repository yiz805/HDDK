<template>
    <div id="activity-full-page">
        <Scroll class="full-page-scroll" :data="activity">
            <div class="content">
                <div class="preview">
                    <ActivityPreview :activity="activity" :show-flag="false" />

                    <div class="progress-bar">
                        <ProgressBar :person-limit="activity.personLimit" :sign-up-number="activity.signUpNumber" />
                    </div>
                </div>

                <div class="hr">
                    <img src="../assets/img/hr.png" alt="分割线" />
                </div>

                <div class="detail">
                    <ActivityDetails :activity="activity" />
                </div>
            </div>
        </Scroll>
    </div>
</template>

<script>
    import ActivityPreview from '../components/ActivityListItem/ActivityPreview'
    import ActivityDetails from '../components/ActivityListItem/ActivityDetails'
    import ProgressBar from '../components/ActivityProgressBar'

    export default {
        name: "ActivityFullPage",
        components: {
            ActivityPreview,
            ActivityDetails,
            ProgressBar
        },
        props: ['id'],
        data() {
            return {
                activity: {},
            }
        },
        methods: {
            getActivity() {
                this.$http.get('/api/activity/' + this.id).then((res) => {
                    this.activity = res.data.activity
                })
            }
        },
        mounted() {
            this.getActivity();
        }
    }
</script>

<style scoped lang="stylus">
    #activity-full-page {
        width: 100vw
        height: calc(100vh - 110px)
        border-top-right-radius 15px
        border-top-left-radius 15px
        overflow hidden
        background #fff
        position absolute
        top 110px
        z-index: 10
        padding 20px
        box-sizing border-box

        .full-page-scroll {
            overflow hidden
            width: 100%;
            height: calc(100vh - 110px)

            .content {
                width: 100%
                overflow auto

                .progress-bar {
                    padding: 25px
                    margin-top -40px
                }

                .hr {
                    padding: 45px 0
                    text-align center

                    img {
                        width: 50vw
                        height: auto
                        opacity .35
                    }
                }
            }
        }
    }
</style>