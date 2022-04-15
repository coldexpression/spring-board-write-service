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