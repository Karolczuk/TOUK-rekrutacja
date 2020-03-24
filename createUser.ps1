$headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
$headers.Add("Content-Type", "application/json")

$body = "{`n   `"name`" : `"Zofia`",`n    `"surname`" : `"Sosenka`",`n   `"username`" : `"Warszawa`"`n}"

$response = Invoke-RestMethod 'http://localhost:8080/user' -Method 'POST' -Headers $headers -Body $body
$response | ConvertTo-Json
