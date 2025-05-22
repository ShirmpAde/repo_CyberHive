function excel() {
    let today = new Date();
    let date = today.getFullYear().toString() + (today.getMonth() + 1).toString().padStart(2, '0') + today.getDate().toString().padStart(2, '0');
    $("table").table2excel({
        exclude: "",
        name: "",
        filename: $("table").attr("data-value") + date, //확장자를 여기서 붙여줘야한다.
        fileext: ".xls",
        exclude_img: true,
        exclude_links: true,
        exclude_inputs: true
    });
}