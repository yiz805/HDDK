<template>
    <div id="activity-preview">
        <div class="flag-color" :style="{background: randomColor}"></div>
        <div class="right-block">
            <div class="ac-info">
                <div class="title">{{ activity.title }}</div>
                <div class="ac-status">{{ activity.status }}</div>
                <div class="clear"></div>
            </div>
            <div class="ac-time">{{ activity.time }}</div>
            <div class="ac-description">{{ activity.description }}</div>
        </div>
        <div class="clear"></div>
    </div>
</template>

<script>
    export default {
        name: "ActivityPreview",
        props: {
            activity: Object
        },
        data() {
            return {
                randomNum: Math.floor(Math.random() * 10 + 1)
            }
        },
        computed: {
            randomColor() {
                switch (this.randomNum) {
                    case 1:
                        return "#44cef6";
                    case 2:
                        return "#177cb0";
                    case 3:
                        return "#db5a6b";
                    case 4:
                        return "#21a675";
                    case 5:
                        return "#c0ebd7";
                    case 6:
                        return "#f35336";
                    case 7:
                        return "#725e82";
                    case 8:
                        return "#549688";
                    case 9:
                        return "#758a99";
                    case 10:
                        return "#41555d";
                }
            }
        }
    }
</script>

<style scoped lang="stylus">
    @import "../../assets/stylus/common.styl"

    #activity-preview {

        .flag-color {
            width: 30px
            height: 130px
            background chocolate
            border-top-right-radius 50%
            border-bottom-right-radius 50%
            float left
            display inline-block
            position relative
            transform translate(-120%, 0%)
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