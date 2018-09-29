<template>
    <div id="activity-details">
        <div class="ac-info">
            <div class="title">活动简介</div>
            <div class="content">
                <div class="block">
                    <div class="icon">
                        <font-icon icon="star"/>
                    </div>
                    <div class="text">思政分：{{ activity.score }} 分</div>
                </div>
                <div class="block">
                    <div class="icon">
                        <font-icon icon="calendar-alt"/>
                    </div>
                    <div class="text">{{ activity.startTime }}</div>
                </div>
                <div class="block">
                    <div class="icon">
                        <font-icon icon="stopwatch"/>
                    </div>
                    <div class="text">{{ activity.signUpStartTime }}</div>
                </div>
            </div>
        </div>
        <div class="ac-description">
            <div class="title">活动描述</div>
            <div class="content">{{ activity.description }}</div>
        </div>
        <div class="ac-tip">
            <div class="title">注意事项</div>
            <div class="content">{{ activity.tips }}</div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Activity-details",
        props: {
            activity: Object
        }
    }
</script>

<style scoped lang="stylus">
    @import "../../assets/stylus/common.styl"

    #activity-details {
        padding 25px

        .title {
            font-size 35px
            margin-bottom: 25px
            text-align center
            title-font()
        }

        .content {
            font-size: 30px;
            line-height 50px
            text-indent 2em
            content-font()
        }

        .ac-info {

            .content {
                text-indent 0
            }

            .block {
                width: 100%
                margin-bottom: 10px
                overflow auto

                .icon {
                    width: 80px
                    height: 60px
                    background #ff9800
                    line-height 60px
                    text-align center
                    display inline-block
                    float left
                    border-top-left-radius 30px
                    border-bottom-left-radius 30px

                    svg {
                        color #fff
                    }
                }

                .text {
                    display inline-block
                    width: calc(100% - 80px)
                    text-align center
                    float left
                    height 60px
                    color #000000bf
                    line-height 60px
                    background #ffbe0059
                    border-top-right-radius 30px
                    border-bottom-right-radius 30px
                }
            }
        }

        .ac-info, .ac-description, .ac-tip {
            margin-bottom 30px
        }
    }
</style>