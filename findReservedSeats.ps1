$response = Invoke-RestMethod 'http://localhost:8080/seats/findReservedSeats/13' -Method 'GET' -Headers $headers -Body $body
$response | ConvertTo-Json