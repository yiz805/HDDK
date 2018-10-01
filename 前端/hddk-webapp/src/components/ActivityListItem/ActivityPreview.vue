<template>
    <div id="activity-preview">
        <div class="flag-color" v-show="showFlag"></div>

        <div class="ac-info">
            <div class="title">{{ activity.title }}</div>
            <div class="ac-status">{{ activity.status }}</div>
            <div class="clear"></div>
        </div>
        <div class="ac-time">{{ activity.time }}</div>
        <div class="ac-description">{{ activity.description }}</div>
    </div>
</template>

<script>
    export default {
        name: "ActivityPreview",
        props: {
            activity: Object,
            showFlag: {
                type: Boolean,
                default: true
            }
        },
        data() {
            return {
                randomNum: Math.floor(Math.random() * 10 + 1)
            }
        }
    }
</script>

<style scoped lang="stylus">
    @import "../../assets/stylus/common.styl"

    #activity-preview {
        padding: 45px 25px;

        .flag-color {
            width: 30px
            height: 30px
            background #fed351
            border-radius 50%
            float left
            display inline-block
            position absolute
            top: 0
            left: 20px
            transform translateY(-50%)
        }

        .right-block {
            width: calc(100% - 35px)
            float right
            display inline-block
        }

        .ac-info {
            margin-bottom: 15px
        }

        .title {
            font-size: 30px;
            float left;
            max-width 80vw
            title-font()
        }

        .ac-status {
            max-width: 20vw
            float right
            font-size 30px
            text-align right
            title-font()
        }

        .ac-time {
            font-size 25px
            margin-bottom: 15px
            tip-font()
        }

        .ac-description {
            font-size 30px
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            content-font()
        }
    }
</style>