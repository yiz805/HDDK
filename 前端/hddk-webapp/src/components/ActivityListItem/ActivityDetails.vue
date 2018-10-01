<template>
    <div id="activity-details">
        <div class="ac-info">
            <div class="title">活动简介</div>
            <div class="content">
                <InfoBlock :content="'思政分' + activity.score + ' 分'">
                    <font-icon icon="star"/>
                </InfoBlock>
                <InfoBlock :content="activity.startTime">
                    <font-icon icon="calendar-alt"/>
                </InfoBlock>
                <InfoBlock :content="activity.signUpStartTime">
                    <font-icon icon="stopwatch"/>
                </InfoBlock>
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
    import InfoBlock from '../InfoBlock'

    export default {
        name: "Activity-details",
        props: {
            activity: Object
        },
        components: {
            InfoBlock
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
        }

        .ac-info, .ac-description, .ac-tip {
            margin-bottom 30px
        }
    }
</style>