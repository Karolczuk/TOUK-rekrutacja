$headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
$headers.Add("Content-Type", "application/json")

$body = "{  `"id`" :5,`n   `"surname`": `"Kowalska`",`n   `"name`" : `"Monika`",`n   `"username`" : `"MONA000`"`n}"

$response = Invoke-RestMethod 'http://localhost:8080/seats/pay' -Method 'POST' -Headers $headers -Body $body
$response | ConvertTo-Json
