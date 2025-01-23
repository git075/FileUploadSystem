const API_BASE_URL = "http://localhost:8080";
<<<<<<< HEAD

=======
>>>>>>> 5fbe2ebf37700dd57953ffb274623d8b015529ba

let shopId;

function registerShop() {
    const shopName = document.getElementById("shopName").value;
    if (!shopName) {
        alert("Please enter a shop name.");
        return;
    }

    fetch(`${API_BASE_URL}/api/shop/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name: shopName })
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("registrationResult").innerText = data;
			shopId = data.match(/shop\/([a-z0-9-]+)/)[1]; 

            document.getElementById("upload-section").style.display = "block";
            document.getElementById("qr-section").style.display = "block";
            loadQRCode();
        })
        .catch(error => {
            console.error("Error registering shop:", error);
            alert("Failed to register shop.");
        });
}

function uploadFile() {
    const fileInput = document.getElementById("fileInput");
    if (!fileInput.files.length) {
        alert("Please select a file to upload.");
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);

    fetch(`${API_BASE_URL}/api/files/${shopId}/upload`, {
        method: "POST",
        body: formData
    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("uploadResult").innerText = data;
        })
        .catch(error => {
            console.error("Error uploading file:", error);
            alert("Failed to upload file.");
        });
}


function loadQRCode() {
    const qrCodeImage = document.getElementById("qrCodeImage");
    qrCodeImage.src = `${API_BASE_URL}/api/qr/${shopId}`;
}






function downloadFiles() {
	console.log(`Full API URL: ${API_BASE_URL}/api/files/${shopId}/download`);
	console.log(`shopId being sent: ${shopId}`);
    fetch(`${API_BASE_URL}/api/files/${shopId}/download`)  
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch files.");
            }
            return response.json();
        })
        .then(fileNames => {
            if (fileNames.length > 0) {
                fileNames.forEach(fileName => {
                    const link = document.createElement("a");
                    link.href = `${API_BASE_URL}/api/files/${shopId}/download/${fileName}`;
                    link.download = fileName;
                    link.click();
                });
            } else {
                alert("No files available for download.");
            }
        })
        .catch(error => {
            console.error("Error downloading files:", error);
            alert("Failed to download files.");
        });
}

<<<<<<< HEAD

=======
>>>>>>> 5fbe2ebf37700dd57953ffb274623d8b015529ba
setInterval(() => {
    if (shopId) {
        downloadFiles();
    }
}, 15000);
