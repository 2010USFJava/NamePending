/**
 * 
 */

 //Bucket Configurations
 var bucketName = "upgradeproject1bucket";
 var bucketRegion = "us-east-2";
 var IdentityPoolId = "us-east-2:487fefa3-8423-4170-ba92-b5b52b7016f4";

AWS.config.update({
              region: bucketRegion,
              credentials: new AWS.CognitoIdentityCredentials({
                  IdentityPoolId: IdentityPoolId
              })
          });

          var s3 = new AWS.S3({
              apiVersion: '2006-03-01',
              params: {Bucket: bucketName}
      });


window.onload=function(){
   document.getElementById("inputGroupFile01").addEventListener("click", s3uploadEvent, false);
   document.getElementById("inputGroupFile02").addEventListener("click", s3uploadApproval, false);

}

function s3uploadEvent() {
	console.log("am i in event?");
   var files = document.getElementById('inputGroupFile01').files;
   if (files) 
   {
     //var file = files[0];
     //var fileName = file.name;
     var fileName = files;
     var filePath = 'upgradeproject1bucket/' + fileName;
     var fileUrl = 'https://upgradeproject1bucket.s3.us-east-2.amazonaws.com/' +  filePath;
     s3.upload({
        Key: filePath,
        Body: files,
        ACL: 'public-read'
        }, function(err, data) {
        if(err) {
        reject('error');
        }
        alert('Successfully Uploaded!');
        }).on('httpUploadProgress', function (progress) {
        var uploaded = parseInt((progress.loaded * 100) / progress.total);
        $("progress").attr('value', uploaded);
      });
   }
}

function s3uploadApproval() {
console.log("am i in approval?");
   var files = document.getElementById('inputGroupFile02').files;
   if (files) 
   {
     var file = files[0];
     var fileName = file.name;
     var filePath = 'upgradeproject1bucket/' + fileName;
     var fileUrl = 'https://upgradeproject1bucket.s3.us-east-2.amazonaws.com/' +  filePath;
     s3.upload({
        Key: filePath,
        Body: file,
        ACL: 'public-read'
        }, function(err, data) {
        if(err) {
        reject('error');
        }
        alert('Successfully Uploaded!');
        }).on('httpUploadProgress', function (progress) {
        var uploaded = parseInt((progress.loaded * 100) / progress.total);
        $("progress").attr('value', uploaded);
      });
   }
};