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

        <transition name="slide-up">
            <router-view />
        </transition>

        <transition name="fade">
            <div class="mask" v-if="showMask" @click="cancelToChoose"></div>
        </transition>

        <div class="ac-button">
            <CButton @button-click="signUp">
                <font-icon icon="edit" />
                {{ buttonTitle }}
            </CButton>
        </div>
    </div>
</template>

<script>
    import ActivityPreview from '../components/ActivityListItem/ActivityPreview'
    import ActivityDetails from '../components/ActivityListItem/ActivityDetails'
    import ProgressBar from '../components/ProgressBar'
    import CButton from '../components/CButton'

    export default {
        name: "ActivityFullPage",
        components: {
            ActivityPreview,
            ActivityDetails,
            ProgressBar,
            CButton
        },
        props: ['id'],
        data() {
            return {
                activity: {},
                showMask: false,
                buttonClickCount: 0
            }
        },
        computed: {
            buttonTitle() {
                if (this.$route.name === 'signUp') {
                    return '确定提交';
                } else {
                    return '立即报名';
                }
            }
        },
        methods: {
            getActivity() {
                this.$http.get('/api/activity/' + this.id).then((res) => {
                    this.activity = res.data.activity
                })
            },
            signUp() {
                // 同一个按钮实例及事件，通过增加counter判断按钮点击时应该执行的事件
                this.buttonClickCount++;
                if (this.buttonClickCount === 1) {
                    this.showMask = true;
                    this.$router.push({
                        name: 'signUp',
                        params: {activity: this.activity}
                    });
                } else if (this.buttonClickCount === 2) {
                    // 按钮第二次点击执行
                    console.log("按钮第二次点击");
                }
            },
            cancelToChoose() {
                // 重置counter、取消背景遮罩
                this.buttonClickCount = 0;
                this.showMask = false;
                this.$router.go(-1);
            }
        },
        mounted() {
            this.showMask = false;
            this.getActivity();
        }
    }
</script>

<style scoped lang="stylus">
    @import "../assets/stylus/animation.styl"

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

        .mask {
            width: 100vw
            height: 100vh
            position absolute
            top: 0
            left: 0
            opacity .3
            background #000
        }

        .full-page-scroll {
            overflow hidden
            width: 100%;
            padding: 20px
            box-sizing border-box
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

                .detail {
                    margin-bottom: 80px
                }
            }
        }

        .ac-button {
            position: fixed;
            bottom: 50px
            left: 50%
            z-index: 20
            transform translateX(-50%)
        }
    }
</style>