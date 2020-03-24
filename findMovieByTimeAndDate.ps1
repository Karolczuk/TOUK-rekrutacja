$headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
$headers.Add("Content-Type", "application/json")

$body = "{ `n  `"date`": `"2020-03-29`",`n  `"time`" :`"14:44:00`"`n}"

$response = Invoke-RestMethod 'http://localhost:8080/repertoire' -Method 'POST' -Headers $headers -Body $body
$response | ConvertTo-Json