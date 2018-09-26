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
        padding: 10px 30px;
        border-radius 40px;
        background darkslategray;
        color: #fff
        font-size 30px;
        display inline-block;
    }
</style>