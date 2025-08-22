<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スシタローオンライン</title>
</head>
<body>
	<h1>スシタローオンライン</h1>
	<p>${ message }</p>
	<table>
		<tr>
			<th>商品名</th>
			<th>商品画像</th>
			<th>金額</th>
			<th>カートに追加</th>
		</tr>
		<c:forEach var="sushi" items="${ sushiList }">
			<tr>
				<td>${ sushi.name }</td>
				<td><img src="img/${ sushi.imagePath }" width="100"
					height="100"></td>
				<td>${ sushi.price }</td>
				<td>
					<form action="CartServlet" method="post">
						<input type="submit" value="カートに追加"> <input type="hidden"
							name="action" value="add"> <input type="hidden"
							name="name" value="${ sushi.name }">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<h2>あなたのカート</h2>
	<table>
		<tr>
			<th>商品名</th>
			<th>商品画像</th>
			<th>金額</th>
			<th>個数</th>
			<th>個別合計金額</th>
			<th>個数変更</th>
			<th>削除</th>
		</tr>
		<c:forEach var="cartItem" items="${ cart.cartItemList }">
			<tr>
				<td>${ cartItem.sushi.name }</td>
				<td><img src="img/${ cartItem.sushi.imagePath }" width="100"
					height="100"></td>
				<td>${ cartItem.sushi.price }</td>
				<td>${ cartItem.quantity }</td>
				<td>${ cartItem.totalPrice }</td>
				<td>
					<form action="CartServlet" method="post">
						<input type="number" name="quantity"
							value="${ cartItem.quantity }"> <input type="submit"
							value="変更"> <input type="hidden" name="action"
							value="updateQuantity"> <input type="hidden" name="name"
							value="${ cartItem.sushi.name }">
					</form>
				</td>
				<td>
					<form action="CartServlet" method="post">
						<input type="submit" value="削除"> <input type="hidden"
							name="action" value="remove"> <input type="hidden"
							name="name" value="${ cartItem.sushi.name }">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p>合計点数：${ cart.totalQuantity }個</p>
	<p>合計金額：${ cart.totalPrice }円</p>
	<p>
	<form action="CartServlet" method="post">
		<input type="submit" value="カートを削除"> <input type="hidden"
			name="action" value="removeCart">
	</form>
	</p>
</body>
</html>