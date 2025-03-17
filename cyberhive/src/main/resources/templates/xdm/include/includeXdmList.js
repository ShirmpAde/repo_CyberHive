let form = document.querySelector("form[name=formList]");
goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = "/codegroup/g";
    form.submit();
}