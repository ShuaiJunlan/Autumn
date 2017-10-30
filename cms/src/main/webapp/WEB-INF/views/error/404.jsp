<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/css/global.css">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">
    <script src="${ctx}/static/layui/layui.js"></script>

    <style type="text/css">
        html, body {
            background: url('${ctx}/static/img/temp-bg.jpg') fixed center center;
        }

        .test {
            max-width: 90%;
            margin: 0 auto;
            padding: 100px 30px 60px;
            margin-bottom: 30px;
            font-size: 26px;
            font-family: "宋体";
            font-weight: normal;
            line-height: 30px;
        }

        .test h1 {
            margin-bottom: 0;
            font-size: 26px;
            line-height: 1.3;
            letter-spacing: -1px;
            color: #fff;
            text-align: center;
            padding-bottom: 20px;
            border-bottom: 2px solid #ccc;
        }

        .test h1 em {
            color: #01AAED;
        }

        .test h1 span#tit {
            color: #FF5722;
            margin-right: 10px;
        }

        .test p {
            text-align: right;
            line-height: 25px;
            margin-top: 20px;
            font-size: 20px;
            color: #ffffff;
        }

        .test h1 .three {
            color: #B00D80;
        }

        .animate {
            display: inline-block;
            font-size: 26px;

        }

        .animate span:nth-of-type(2) {
            animation-delay: .05s;
        }

        .animate span:nth-of-type(3) {
            animation-delay: .1s;
        }

        .animate span:nth-of-type(4) {
            animation-delay: .15s;
        }

        .animate span:nth-of-type(5) {
            animation-delay: .2s;
        }

        .animate span:nth-of-type(6) {
            animation-delay: .25s;
        }

        .animate span:nth-of-type(7) {
            animation-delay: .3s;
        }

        .animate span:nth-of-type(8) {
            animation-delay: .35s;
        }

        .animate span:nth-of-type(9) {
            animation-delay: .4s;
        }

        .animate span:nth-of-type(10) {
            animation-delay: .45s;
        }

        .animate span:nth-of-type(11) {
            animation-delay: .5s;
        }

        .animate span:nth-of-type(12) {
            animation-delay: .55s;
        }

        .animate span:nth-of-type(13) {
            animation-delay: .6s;
        }

        .animate span:nth-of-type(14) {
            animation-delay: .65s;
        }

        .animate span:nth-of-type(15) {
            animation-delay: .7s;
        }

        .three span {
            color: #b10e81;
            opacity: 0;
            transform: translate(-300px, 0) scale(0);
            animation: sideSlide .5s forwards;
        }

        @keyframes sideSlide {
            60% {
                transform: translate(20px, 0) scale(1);
                color: #b10e81;
            }
            80% {
                transform: translate(20px, 0) scale(1);
                color: #b10e81;
            }
            99% {
                transform: translate(0) scale(1.2);
                color: #00f0ff;
            }
            100% {
                transform: translate(0) scale(1);
                opacity: 1;
                color: #b10e81;
            }
        }
    </style>
</head>
<body class="page">
<div class="larry-wrapper">
    <div class="test">
        <h1>

            <em>温馨提示：</em>
            <span id="tit">404-Not Found</span>
            <div class="animate three" id="animates">
                <span>-</span>
                <span>-</span>
                <span>-</span>
                <span>您</span>
                <span>当</span>
                <span>前</span>
                <span>访</span>
                <span>问</span>
                <span>的</span>
                <span>页</span>
                <span>面</span>
                <span>不</span>
                <span>存</span>
                <span>在</span>
                <span>.</span>
                <span>.</span>
                <span>.</span>
            </div>
        </h1>
        <p>---by 后台管理系统</p>
    </div>
</div>
<script type="text/javascript">

    layui.use('layer', function () {
        var $ = layui.jquery,
                layer = layui.layer;

        function animateTo() {
            var classes = $('#animates').attr('class');
            $('#animates').attr('class', 'animate');
            var indicator = $('#animates');
            setTimeout(function () {
                $(indicator).addClass(classes)
            }, 300)
        }

        var timer = setInterval(animateTo, 2000)
    })
</script>
</body>
</html>