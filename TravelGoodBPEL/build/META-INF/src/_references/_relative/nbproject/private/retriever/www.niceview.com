    <html data-adblockkey="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANHZLSNGAhe0lWbSycFlY7t3c4tFHP+Epw8naGgm3CR8CftAihnB7Jkt+vFmvIf3BV/p3RpOrZ/XbZsX9uh0m9UCAwEAAQ==_ssfHZASpMg6JCDdK42JuJQI3+D/2aO0aVI2Kuc0fDr7JHMjc3OI1tnWWAh6UEiHYErOVTJ6ltYNJg3O4eJ69bA==">

<head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>NiceView.com</title>
            <script type="text/javascript">;
        if(self != top) top.location.href = 'http://'+location.hostname+'/?redir=frame&uid=www58359e1f27c3e3.62062350';
        </script>
            <script type="text/javascript" src="http://return.uk.uniregistry.com/return_js.php?d=niceview.com&s=1479908895"></script>
    
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
    <script type="text/javascript">
        function GetParam(name) {
            var match = new RegExp(name +
                "=*([^&]+)*", "i").exec(location.search);
            if (match == null)
                match = new RegExp(name + "=(.+)", "i").exec(location.search);
            if (match == null) return null;
                match = match + "";
            //**convert match to a string
            result = match.split(",");
            return decodeURIComponent(result[1]);
        }

        function logStatus(type) {
            $.ajax({
                cache: false,
                global: false,
                async: true,
                type: "POST",
                url: '/logpstatus.php',
                data: {uid: GetParam('uid'), type: type}
            });
        }
    </script>

    </head>
    <frameset cols="1,*,1" border=0>
        <frame name="top" src="tg.php?uid=www58359e1f27c3e3.62062350" scrolling=no frameborder=0 noresize framespacing=0 marginwidth=0 marginheight=0>
        <frame src="search_caf.php?uid=www58359e1f27c3e3.62062350&src=mountains&abp=1&country=ZZ" scrolling="auto" framespacing=0 marginwidth=0 marginheight=0 noresize>
        <frame src="page.php?www58359e1f27c3e3.62062350"></frame>
    </frameset>
    <noframes>
        You found niceview.com, so will your customers. It's a great label for your website and will help you define your identity on the Web.    </noframes>
</html>

