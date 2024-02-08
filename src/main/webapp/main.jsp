<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<body>
    <div class="container mt-5">
        <!-- 신착 도서 슬라이드 -->
        <div id="newBooksCarousel" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
            <h2>신착도서</h2>
                <div class="carousel-item active"><a href="goods?cmd=detail&code=이처럼%20_소설_2024">
                    <img src="images/sdimg/big_banner1.jpg" class="d-block w-100" alt="신착 도서 1" ></a>
                </div>
                <div class="carousel-item"><a href="goods?cmd=detail&code=무조건%20_요리_2023">
                    <img src="images/sdimg/big_banner2.jpg" class="d-block w-100" alt="신착 도서 2"  >
                    </a>
                </div>
                <div class="carousel-item"><a href="goods?cmd=detail&code=Do%20i_IT_2022">
                    <img src="images/sdimg/big_banner3.jpg" class="d-block w-100" alt="신착 도서 3"></a>
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
            <a href="goods?cmd=detail&code=미키7%20_소설_2023">
                <img src="upload/small/미키7 _소설_2023.jpg" class="img-fluid" alt="추천 도서 1" width="38%">
                </a>
                <h5 class="book-title">미키7 반물질의 블루스</h5>
                <p class="book-description">에드워드 애슈턴(저) | 황금가지</p>
                <h6> 15,300원</h6>
            </div>
            <div class="col-md-6 mt-4">
            <a href="goods?cmd=detail&code=이처럼%20_소설_2024">
                <img src="upload/small/이처럼 _소설_2024.jpg" class="img-fluid" alt="추천 도서 2" width="41%">
                </a>
                <h5 class="book-title">이처럼 사소한 것들</h5>
                <p class="book-description">클레어 키건(저) | 다산책방</p>
                <h6> 12,420원</h6>
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
