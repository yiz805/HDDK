<template>
    <div id="sign-up-page">
        <div class="choose-place">
            <div class="title">选择活动参与地点</div>
            <div class="choose-block" v-if="activity">
                <div :class="{'active': choosenIndex === index}" class="choose-item" v-for="(field, index) in activity.fields" @click="chooseField(field, index)">场地{{ index + 1 }}</div>
            </div>
        </div>
        <div class="place-info">
            <div class="title">
                活动地点详情
            </div>
            <div class="place-info-block" v-if="activity">
                <InfoBlock :content="activity.fields[choosenIndex].info">
                    <font-icon icon="map-marker-alt"/>
                </InfoBlock>
                <InfoBlock :content="'未知 / ' + activity.fields[choosenIndex].signUpNumLimit">
                    <font-icon icon="users"/>
                </InfoBlock>
                <InfoBlock :content="activity.fields[choosenIndex].name">
                    <font-icon icon="user"/>
                </InfoBlock>
                <InfoBlock :content="activity.fields[choosenIndex].tel">
                    <font-icon icon="phone"/>
                </InfoBlock>
            </div>
        </div>
    </div>
</template>

<script>
    import InfoBlock from '../components/InfoBlock'

    export default {
        name: "SignUpPage",
        components: {
            InfoBlock
        },
        data() {
            return {
                choosenPlace: {},
                choosenIndex: 0
            }
        },
        computed: {
            activity() {
                return this.$route.params.activity
            }
        },
        methods: {
            chooseField(field, index) {
                this.choosenIndex = index;
                this.choosenPlace = field;
            }
        },
        mounted() {
            if (this.activity === undefined) {
                this.$router.replace("/");
            }
        }
    }
</script>

<style scoped lang="stylus">
    #sign-up-page {
        background #fff
        position absolute
        z-index 15
        bottom 0
        width: 100vw
        box-shadow 0 8px 50px 0 #999
        border-top-left-radius 20px
        border-top-right-radius 20px
        overflow hidden

        .title {
            font-size 30px
            margin-bottom: 20px
            title-font()
        }

        .choose-place {
            background #fed351
            padding: 30px

            .choose-item {
                padding: 10px 25px
                border-radius 30px
                background #fed351
                border 1px solid #fff
                color: #fff
                display inline-block
                margin-right: 20px
                transition all .35s ease
            }

            .active {
                color: #fed351
                background #fff
            }
        }

        .place-info {
            padding: 30px 30px 130px

            .place-info-block {
                font-size 30px
                content-font()
            }
        }
    }
</style>