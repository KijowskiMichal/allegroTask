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
					<div class="subheading" >
						Nazwa konta
					</div>
					<div class="text" >
						blablabla
					</div>
					<div class="spacerSmall" ></div>
					<div class="subheading" >
						Liczba gwiadek
					</div>
					<div class="text" >
						<i class="fa fa-star icon"></i>
						69
					</div>
				</div>
				<div class="spacerSmall" ></div>
				<div class="bodyCardBorder" >
					<div class="heading" >
						Lista repozytoriów
					</div>
					<div class="spacerSmall" ></div>
                    <div class="cardItem" >
                        <div class="cardItemPrimary" >
                            Repo #1
                        </div>
                        <div class="cardItemSecondary" >
                            <i class="fa fa-star icon"></i>
                            5
                        </div>
                    </div>
                    <div class="cardItem" >
                        <div class="cardItemPrimary" >
                            Repo #2
                        </div>
                        <div class="cardItemSecondary" >
                            <i class="fa fa-star icon"></i>
                            9
                        </div>
                    </div>
                    <div class="cardItem" >
                        <div class="cardItemPrimary" >
                            Repo #3
                        </div>
                        <div class="cardItemSecondary" >
                            <i class="fa fa-star icon"></i>
                            1
                        </div>
                    </div>
                    <div class="cardItem" >
                        <div class="cardItemPrimary" >
                            Repo #4
                        </div>
                        <div class="cardItemSecondary" >
                            <i class="fa fa-star icon"></i>
                            11
                        </div>
                    </div>
					<div class="spacerSmall" ></div>
					<div id="pageChooser" >
						<div class="pageChooser" >
							<a href="" >
								<i class="fa fa-angle-left icon"></i>
							</a>
							<span>Strona 2 z 3</span>
							<a href="" >
								<i class="fa fa-angle-right icon"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div id="bodyCardRight" >
				<div class="bodyCardBorder" >
					<div class="heading" >
						Ostatnie zapytania
					</div>
					<div class="spacerSmall" ></div>
					<a href="${pageContext.request.contextPath}/login1/" >
						<div class="cardItem" >
							<div class="cardItemPrimary" >
								login #1
							</div>
							<div class="cardItemSecondary" >
								<i class="fa fa-star icon"></i>
								54
							</div>
						</div>
					</a>
					<a href="${pageContext.request.contextPath}/login2/" >
						<div class="cardItem" >
							<div class="cardItemPrimary" >
								login #2
							</div>
							<div class="cardItemSecondary" >
								<i class="fa fa-star icon"></i>
								69
							</div>
						</div>
					</a>
					<a href="${pageContext.request.contextPath}/login3/" >
						<div class="cardItem" >
							<div class="cardItemPrimary" >
								login #3
							</div>
							<div class="cardItemSecondary" >
								<i class="fa fa-star icon"></i>
								84
							</div>
						</div>
					</a>
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
