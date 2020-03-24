
$headers = New-Object "System.Collections.Generic.Dictionary[[String],[String]]"
$headers.Add("Content-Type", "application/json")

$body = "{ `n  `"dateFrom`" : `"2020-02-10`",`n  `"dateTo`" : `"2020-05-11`"`n}"

$response = Invoke-RestMethod 'http://localhost:8080/repertoire/findAll' -Method 'POST' -Headers $headers -Body $body
$response | ConvertTo-Json
