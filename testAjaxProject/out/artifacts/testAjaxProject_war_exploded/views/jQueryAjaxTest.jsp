<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>jQuery와 Ajax연습</title>
    <script src="../resources/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<h1>jQuery와 Ajax연습</h1>
<p>
    Ajax란, 사용자가 요청한 정보를 응답할 때<br>
    다른 페이지로 갱신하지 않고, 현재 페이지에 <br>
    데이터를 추가하는 방식의 비동기 통신 방식.<br>
    <br>
    별도의 페이지 새로고침, 페이지 이동이 일어나지 않기 때문에<br>
    사용자는 실시간 같은 느낌을 받을 수 있고, 서버에서는 갱신한<br>
    최신 정보를 사용자에게 제공할 수 있다.<br>
    단, 페이지 내부에 요청한 정보들이 누적되어 처리되기 때문에<br>
    남용할 경우 페이지가 점차적으로 느려질 수 있다.<br>
    (페이지 리소스 과부하 현상)
</p>

<h3>1. 버튼 클릭 시 전송값을 서버로 전달하기</h3>
<input type="text" id="myName"/>
<button id="nameBtn">ajax 통신하기</button>
<script>
    //jQuery.ajax
    /* $.ajax({
        url:'요청 주소', /test/test.do
        type:'get/post', / get
        data:"전달할 값" / {name : "홍길동",age:20},
        ///test/test.do?name=홍길동&age=20
        async:true/false(비동기/동기 사용여부),
        dataType:"text/html", // 서버에서 응답하는 데이터 유형
        success:function(result){...},
        error:function(error,code,msg){...},
        complete:function(){...}// 무조건 실행하는 함수
    }); */
    $('#nameBtn').click(function () {
        $.ajax({
            url: "/ajax/test1.do",
            type: "get",
            data: {
                name: $('#myName').val()
            }, success: function (result) {
                alert("전송 성공!" + result);
            }, error: function () {
                alert("전송 실패!");
            }, complete: function () {
                alert('무조건 실행하는 함수');
            }
        });
    });
</script>


<h3>2. 버튼 클릭 시 서버에서 보낸 값을 사용자가 확인</h3>
<button id="getResponseBtn">Ajax통신하기</button>
<script>
    $('#getResponseBtn').click(function () {
        $.ajax({
            url: "/ajax/test2.do",
            type: "get",
            data: {name: "김유신"},
            success: function (data) {
                console.log(data);
            }, error: function () {
                console.log("수신실패!");
            }
        });
    });
</script>

<h3>3. 서버로 기본 데이터 전송하고, 결과로 문자열 받기</h3>
<h3>이름과 나이를 입력하세요!</h3>
<p>
    이름:<input type="text" id="myName2"><br>
    나이:<input type="number" id="myAge">
</p>
<button id="testBtn3">
    Ajax 결과 확인
</button>

<p id="testP3" style="width:400px; height:auto; border:3px solid tomato;"></p>

<script>
    $('#testBtn3').click(function () {
        $.ajax({
            url: "/ajax/test3.do",
            type: "get",
            data: {
                myName: $('#myName2').val(),
                myAge: $('#myAge').val()
            }, success: function (result) {
                $('#testP3').text(result);
            }, error: function (request, errorcode, error) {
                console.log("실패입니다.");
                console.log(request);
                console.log(errorcode);
                console.log(error);
            }
        });
    });
</script>

<h3>4. 서버로 json(자바스크립트 객체)방식으로 데이터 전송 및 <br>
    서버에서 처리한 결과를 반환하여 출력하기
</h3>
초대가수1 : <input type="text" id="singer1"><br>
초대가수2 : <input type="text" id="singer2"><br>
초대가수3 : <input type="text" id="singer3"><br>

<button id="testBtn4">ajax 결과 확인</button>
<script>
    $('#testBtn4').click(function () {
        var jsonData = new Object();
        jsonData.singer1 = $('#singer1').val();
        jsonData.singer2 = $('#singer2').val();
        jsonData.singer3 = $('#singer3').val();

        console.log(jsonData);

        $.ajax({
            url: "/ajax/test4.do",
            type: "get",
            data: jsonData,
            success: function (data) {
                alert("전송성공!");
            }, error: function (data) {
                console.log("전송실패");
            }
        });

    });
</script>

<h3>5. 서버로 기본 데이터 전송하고, 서버로부터 자바 객체 받아오기</h3>
<h4>사용자 번호를 보내서 해당하는 번호와 일치하는 사용자 정보 가져오기</h4>
사용자 번호 : <input type="number" id="userIdx"><br>

<button id="testBtn5">ajax 통신 확인</button>
<p id="testP5" style="width:400px; height:50px; border:3px solid violet"></p>

<script>
    $('#testBtn5').click(function () {
        $.ajax({
            url: "/ajax/test5.do",
            type: "get",
            data: {
                userIdx: $('#userIdx').val()
            }, success: function (data) {
                console.log(data);// -->
                console.log(data.userNo);
                var resultStr = data.userNo + ","
                    + data.userName + ","
                    + data.gender + ","
                    + data.phone;
                $('#testP5').text(resultStr);
            }, error: function (data) {
                console.log("실패!");
            }
        });
    });

</script>

<h3>6. 서버로 기본값 전송하고, 서버에서 리스트 반환하기</h3>
<h4>사용자 정보 요청 -> 해당 사용자가 없으면 전체 사용자 정보를 가져오고, <br> 있으면 해당 사용자의 정보만 가져오기</h4>
사용자 번호 : <input type="number" id="userIdx2"><br>
<button id="testBtn6">ajax 결과 확인</button>
<br>
<textarea rows="10" cols="30" id="testTA6"
          style="border:3px solid purple"></textarea>
<script>
    $('#testBtn6').click(function () {
        $.ajax({
            url: "/ajax/test6.do",
            type: "get",
            data: {
                userIdx: $('#userIdx2').val()
            }, success: function (data) {
                console.log(data);
                var resultStr = "";

                for (var index in data.list) {
                    var user = data.list[index];

                    resultStr += user.userNo + ", "
                        + user.userName + ", "
                        + user.gender + ", "
                        + user.phone + "\n";
                }

                $('#testTA6').html(resultStr);

            }, error: function (data) {
                console.log("데이터 통신 실패" + data);
            }
        });
    });

</script>
<h3>7. 여러 값을 서버에 전ㅇ송하고, 서버에서 리스트 출력하기</h3>
<h4>사용자 번호를 여러 개 전송하고, 번호에 맞는 사용자 정보를 리스트로 반환하여 출력하기</h4>
사용자 번호(, ) : <input type="text" id="userIdx3"> &nbsp;&nbsp;
<button id="testBtn7">ajax 실행확인</button>
<p id="testP7" style="width: 400px; height: auto; border: 3px solid hotpink;"></p>
<script>
    $('#testBtn7').click(function () {
        $.ajax({
            url: "/ajax/test7.do",
            type: "get",
            data: {
                userIdx: $('#userIdx3').val()
            }, success: function (data) {
                console.log(data);
                var resultStr = "";

                for (var index in data.list) {
                    var user = data.list[index];

                    resultStr += user.userNo + ", "
                        + user.userName + ", "
                        + user.gender + ", "
                        + user.phone + "<br>";
                }

                $('#testP7').html(resultStr);

            }, error: function () {
                console.log("전송실패!");

            }
        });

    });
</script>
<h3>8. 서버로 기본데이터 전송하고 맵 객체로 받아오기</h3>
사용자 번호(, ): <input type="text" id="userIdx4">
<button id="testBtn8">ajax 결과 확인</button>
<p id="testP8" style="border: 3px solid blue;"></p>

<script>
    $('#testBtn8').click(function () {
        $.ajax({
            url: "/ajax/test8.do",
            type: "get",
            data: {
                userIdx: $('#userIdx4').val()
            }, success: function (data) {
                console.log(data);
                var resultStr = "";
                for (var index in data) {
                    var user = data[index];
                    resultStr += user.userNo + ","
                        + user.userName + ","
                        + user.gender + ","
                        + user.phone + ","
                }
                $('#testP8').html(resultStr);

            }, error: function () {
                console.log("전송실패!");
            }
        })

    })
</script>
<h3>9. 서버의 사용자 정보를 표로 구성하기</h3>
<button id="userTableBtn">정보 불러오기</button>

<table id="userTable" border="1">
    <thead>
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>성별</th>
        <th>연락처</th>
    </tr>
    </thead>
</table>
<script>
    $('#userTableBtn').click(function () {
        $.ajax({
            url: "/ajax/test9.do",
            type: "get",
            success: function (data) {
                console.log(data);
                $.each(data,function (index,value) {
                    var $tr = $('<tr>');
                    var $userNo = $('<td>').text(value.userNo);
                    var $userName = $('<td>').text(value.userName);
                    var $gender = $('<td>').text(value.gender);
                    var $phone = $('<td>').text(value.phone);
                    $tr.append($userNo);
                    $tr.append($userName);
                    $tr.append($gender);
                    $tr.append($phone);

                    $('#userTable').append($tr);
                });
            }, error: function () {
                console.log("에러입니다.");

            }
        })

    })
</script>
</body>
</html>


















