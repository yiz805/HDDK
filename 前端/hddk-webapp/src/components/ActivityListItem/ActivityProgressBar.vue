<template>
    <div id="activity-progress-bar">
        <div class="block">
            <span :style="{width: percentage, background: color }"></span>
        </div>

        <div class="number">
            <div class="real-num">{{ signUpNumber }} / {{ personLimit }}</div>
            <div class="percentage">{{ percentage }}</div>
        </div>

        <div class="clear"></div>
    </div>
</template>

<script>
    export default {
        name: "ActivityProgressBar",
        props: {
            personLimit: Number,
            signUpNumber: Number,
            color: String
        },
        computed: {
            percentage() {
                return Math.ceil((this.signUpNumber / this.personLimit) * 100) + "%";
            }
        }
    }
</script>

<style scoped lang="stylus">
    @import "../../assets/stylus/common.styl"

    #activity-progress-bar {

        .block {
            width: 100%;
            height: 20px;
            background #eee;
            border-radius 10px;
            position relative;
            overflow hidden;
            margin-bottom 15px

            span {
                width: 10%
                height: 20px;
                position absolute
                top: 0;
                left: 0;
                border-radius 10px;
                background darkslategray
            }
        }

        .number {
            content-font()
            font-size 27px
            padding 0 10px
            height: 27px

            .real-num {
                float: left
            }

            .percentage {
                float: right
                text-align right
            }
        }
    }
</style>