<template>
    <div id="custom-button" @click="clickEvent()">
        <slot></slot>
    </div>
</template>

<script>
    export default {
        name: "CButton",
        methods: {
            clickEvent() {
                this.$emit("button-click");
            }
        }
    }
</script>

<style scoped lang="stylus">
    #custom-button {
        padding: 10px 40px;
        border-radius 40px;
        background linear-gradient(to right , rgb(26, 207, 255) , rgb(255, 88, 213) 100%);
        color: #fff
        font-size 30px;
        display inline-block;
        box-shadow 0 10px 50px -10px #000
    }
</style>