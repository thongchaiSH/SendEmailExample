$(document).ready(function(){$("a#loginLink[data-login-path]").click(function(c){c.preventDefault();var b=$(this).attr("data-login-path");var d=$(this).attr("href");var a=$('<form method="post" action="'+d+'"></form>');a.append('<input type="hidden" name="returnPath" value="'+b+'" />');a.appendTo("body");a.submit()});$(".selectAllOnFocus").click(function(){$(this).select()})});function showEmail(b,a){return b+"@"+a};