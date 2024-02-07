<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<!-- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>대현문고 main</title>
    Bootstrap CSS
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    Custom CSS for Black & White theme
    <style>
/*         body { */
            color: #333;
            background-color: #fff;
        }
        .navbar, .footer {
            background-color: #000;
            color: #fff;
        }
        .carousel-inner img {
            filter: grayscale(100%);
        }
        .book-title {
            color: #000;
        }
        .book-description {
            color: #666;
        }
    </style>
</head> -->
<body>
    <div class="container mt-5">
        <!-- 신착 도서 슬라이드 -->
        <div id="newBooksCarousel" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="path/to/newBook1.jpg" class="d-block w-100" alt="신착 도서 1">
                </div>
                <div class="carousel-item">
                    <img src="path/to/newBook2.jpg" class="d-block w-100" alt="신착 도서 2">
                </div>
                <div class="carousel-item">
                    <img src="path/to/newBook3.jpg" class="d-block w-100" alt="신착 도서 3">
                </div>
            </div>
            <a class="carousel-control-prev" href="#newBooksCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#newBooksCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <!-- 오늘의 추천 도서 -->
        <h2 class="mt-5">오늘의 추천 도서</h2>
        <div class="row">
            <div class="col-md-6 mt-4">
                <img src="path/to/recommendedBook1.jpg" class="img-fluid" alt="추천 도서 1">
                <h5 class="book-title">도서 제목 1</h5>
                <p class="book-description">도서 설명 1</p>
            </div>
            <div class="col-md-6 mt-4">
                <img src="path/to/recommendedBook2.jpg" class="img-fluid" alt="추천 도서 2">
                <h5 class="book-title">도서 제목 2</h5>
                <p class="book-description">도서 설명 2</p>
            </div>
        </div>
    </div>
    <%@ include file="/include/footer.jsp" %>
    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
