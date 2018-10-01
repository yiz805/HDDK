<template>
    <div id="activity-progress-bar">
        <div class="block">
            <span :style="{width: percentage  + '%', background: color }"></span>
        </div>

        <div class="number">
            <div class="real-num">
                {{ signUpNumber }}
                <span>/</span>
                {{ personLimit }}
            </div>
            <div class="percentage">
                <font-icon icon="percentage"/>
                {{ percentage }}
            </div>
        </div>

        <div class="clear"></div>
    </div>
</template>

<script>
    export default {
        name: "ActivityProgressBar",
        props: {
            personLimit: Number,
            signUpNumber: Number
        },
        computed: {
            percentage() {
                return Math.ceil((this.signUpNumber / this.personLimit) * 100);
            },
            color() {
                if (this.percentage < 50) {
                    return '#fed35182';
                } else if (this.percentage < 85) {
                    return '#fed351'
                } else {
                    return '#fe4f36'
                }
            }
        }
    }
</script>

<style scoped lang="stylus">
    @import "../assets/stylus/common.styl"

    #activity-progress-bar {

        .block {
            width: 100%;
            height: 20px;
            background #eee;
            border-radius 10px;
            position relative;
            overflow hidden;
            margin-bottom 20px

            span {
                width: 10%
                height: 20px;
                position absolute
                top: 0;
                left: 0;
                border-radius 10px;
                background #fed351
            }
        }

        .number {
            content-font()
            font-size 27px
            padding 0 15px
            height: 27px

            span {
                margin: 0 10px
            }

            .progress-icon {
                font-size 22px
                margin-right: 10px
            }

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