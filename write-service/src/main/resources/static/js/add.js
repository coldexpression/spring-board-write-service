function showText() {
    const reader = new FileReader();

    document.querySelector("#path").addEventListener("change", (changeEvent) => {

        const imgFile = changeEvent.target.files[0];
        reader.readAsDataURL(imgFile);

        const fileName = document.getElementById("path_text");
        fileName.value = imgFile.name;
        //파일 이름을 띄워줌
    })
}

function fileCheck() {
    var imgFile = document.getElementsByClassName("upload-hidden");
    var fileName = document.getElementById("path_text");
    var titleName = document.getElementsByClassName("title");
    var maxSize = 5 * 1024 * 1024;
    var fileSize = imgFile[0].files[0].size;
    var fileForm = /(.*?)\.(jpg|JPG|jpeg|PNG|png)$/;
    console.log(imgFile[0].files[0].name);
    if (!fileForm.test(imgFile[0].files[0].name)) {
        alert("잘못된 확장자 파일입니다.");
        fileName.value = '';
        return;
    } else if (fileSize >= maxSize) {
        alert("파일 사이즈는 5MB 까지 가능합니다.");
        fileName.value = '';
        return;
    } else {
        fileName.value = imgFile[0].files[0].name;
}
}