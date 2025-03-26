let form = document.querySelector("form[name=formList]");
goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = "/codegroup/g";
    form.submit();
}

document.getElementById("btnForm").onclick = function () {
    goForm(0);
}

goForm = function (keyValue) {
    seq.value = keyValue;
    form.action = goUrlXdmForm;
    form.submit();
}