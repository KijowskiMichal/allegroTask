<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype>
<html>
	<head>
		<title>Github listing repos</title>
		<meta charset="UTF-8">
		<%@ page contentType="text/html; charset=UTF-8" %>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" >
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>
	<body>
		<div id="messageBlank" >
			<div id="message">
				<div id="messageWrapper">
					<div class="heading" >
						Informacja
					</div>
					<div class="text" >
						Nie ma kogoś takiego.
					</div>
				</div>
				<div id="messageHr"></div>
				<div id="messageWrapper">
					<div id="messageButton">
						OK
					</div>
				</div>
			</div>
		</div>
		<div id="header">
			<form id="searcherForm">
				<i id="searcherIcon" class="fa fa-user icon"></i>
				<input type="text" id="searcher" placeholder="Wyszukaj użytkownika..." >
			</form>
		</div>
		<div class="spacer" ></div>
		<div id="bodyContainer">
			<div id="bodyCardLeft" >
				<div class="bodyCardBorder" >
					<div class="heading" >
						Informacje o koncie
					</div>
					<div class="text" >
						Wybierz najpierw z jakiego konta chcesz wyświetlić repozytoria
					</div>
				</div>
				<div class="spacerSmall" ></div>
				<div class="bodyCardBorder" >
					<div class="heading" >
						Lista repozytoriów
					</div>
					<div class="text" >
						Wybierz najpierw z jakiego konta chcesz wyświetlić repozytoria
					</div>
				</div>
			</div>
			<div id="bodyCardRight" >
				<div class="bodyCardBorder" >
					<div class="heading" >
						Ostatnie zapytania
					</div>
					<div class="spacerSmall" ></div>
					<c:forEach items="${lastRequests}" var="lastRequest">
                        <a href="${pageContext.request.contextPath}/${lastRequest.nickname}/" >
                            <div class="cardItem" >
                                <div class="cardItemPrimary" >
                                    ${lastRequest.nickname}
                                </div>
                                <div class="cardItemSecondary" >
                                    <i class="fa fa-star icon"></i>
                                    ${lastRequest.stars}
                                </div>
                            </div>
                        </a>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
	<script>
		document.getElementById("messageButton").onclick = function() 
		{
			document.getElementById("messageBlank").style.visibility = "hidden";
			document.getElementById("messageBlank").style.opacity = 0;
		}
		
		var input = document.getElementById("searcher");
		input.addEventListener("keyup", function(event) {
			if (event.keyCode === 13) {
				location.href =  "${pageContext.request.contextPath}/"+document.getElementById("searcher").value+"/";
			}
		});
		
		window.onload = function() {
		var form = document.querySelector("form");
			form.onsubmit = submitted.bind(form);
		}

		function submitted(event) {
			event.preventDefault();
		}
	</script>
</html>
