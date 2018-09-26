<template>
    <div id="activity-preview">
        <div class="basic-info">
            <div class="title">{{ activity.title }}</div>
            <div class="ac-status">{{ activity.status }}</div>
            <div class="clear"></div>
        </div>

        <div class="ac-time">{{ activity.time }}</div>

        <ActivityProgressBar :person-limit="activity.personLimit" :sign-up-number="activity.signUpNumber" :color="randomColor"/>

    </div>
</template>

<script>
    import ActivityProgressBar from './ActivityProgressBar'
    import CButton from '../CButton'

    export default {
        name: "ActivityPreview",
        props: {
            activity: Object
        },
        components: {
            ActivityProgressBar,
            CButton
        },
        data() {
            return {
                randomNum: Math.floor(Math.random() * 5 + 1)
            }
        },
        computed: {
            randomColor() {
                switch(this.randomNum) {
                    case 1:
                        return "linear-gradient(to right, #44a08d, #093637)";
                    case 2:
                        return "linear-gradient(to right, #4568dc, #b06ab3)";
                    case 3:
                        return "linear-gradient(to left, #093028, #237a57)";
                    case 4:
                        return "linear-gradient(to right, #c0c0aa, #1cefff)";
                    case 5:
                        return "linear-gradient(to right, #67b26f, #4ca2cd)";
                }
            }
        }
    }
</script>

<style scoped lang="stylus">
    @import "../../assets/stylus/common.styl"

    #activity-preview {

        .basic-info {
            margin-bottom: 15px

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
        }

        .ac-time {
            font-size 25px
            tip-font()
            margin-bottom: 25px;
        }

        .c-button {
            margin-top: 20px;
            position relative
            left: 50%
            transform translateX(-50%)
        }
    }
</style>