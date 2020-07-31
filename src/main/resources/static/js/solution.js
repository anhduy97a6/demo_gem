$(document).ready(function() {
    var dataColumn = {};
    var attrInfo;

    $(".column-delete").on("click",function(){
        attrInfo = $(this).data("columnid");
        console.log(attrInfo);
    });

    $(".delete-column").on("click",function(){


        console.log(attrInfo);
        NProgress.start();
        var linkGet = "/api/attributes/delete/"+attrInfo;
        axios.get(linkGet).then(function(res){
            NProgress.done();
            if(res.data.success) {
                swal(
                    'Success',
                    res.data.message,
                    'success'
                ).then(function() {
                    location.reload();
                });
            } else {
                swal(
                    'Fail',
                    res.data.message,
                    'error'
                );
            }
        }, function(err){
            NProgress.done();
            swal(
                'Error',
                'Fail',
                'error'
            );
        })
    });
    $("#add-column").on("click",function(){
        dataColumn.name = $('#input-column-name').val();


        NProgress.start();
        var linkPost = "/api/attributes/add";
        var link = "/api/attributesvalue/add";
        axios.post(linkPost, dataColumn).then(function(res){
            NProgress.done();
            if(res.data.success) {
                dataColumn.id = res.data.data;
                console.log(dataColumn)
                axios.post(link, dataColumn);
                swal(
                    'Good job!',
                    res.data.message,
                    'success'
                ).then(function () {
                    location.reload();
                });


            }else {
                wal(
                    'Error',
                    res.data.message,
                    'error'
                );
            }
        }, function(err){
            NProgress.done();
        })
    });



});