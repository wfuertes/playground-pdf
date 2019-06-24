<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Invoice PDF</title>
    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
        }

        @page {
            margin: auto;
            height:297mm;
            width:210mm;
        }

        .header > .logo {
            float: left;
        }

        .header > .logo > img {
            width: 150px;
        }

        .header > .title {
            float: left;
            padding-left: 100px;
            padding-right: 100px;
        }

        .content {
            clear: both;
            padding: 10px;
        }

        .content > .report {
            margin-top: 10px;
        }
        
        tr {
            page-break-inside: avoid;
        }

        .report-content {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        .report-content td, .report-content th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        .report-content tr:nth-child(even){background-color: #f2f2f2;}

        .report-content tr:hover {background-color: #ddd;}

        .report-content th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="logo">
        <img src="/images/fake-logo.png" alt="logo"/>
    </div>
    <div class="title">
        <h2>Cool Report</h2>
    </div>
</div>
<div class="content">
    <div class="details">
        <div>
            <label>Name:</label>
            <span>${report.employee}</span>
        </div>
        <div>
            <label>Email:</label>
            <span>${report.email}</span>
        </div>
    </div>
    <div class="report">
        <table class="report-content">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Description</th>
                    <th>Bonus</th>
                </tr>
            </thead>
            <tbody>
                <#list report.bonuses as bonus>
                    <tr>
                        <td>${bonus.date}</td>
                        <td>${bonus.description}</td>
                        <td>${bonus.value}</td>
                    </tr>
                </#list>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="2">TOTAL</td>
                    <td>${report.totalBonuses}</td>
                </tr>
            </tfoot>
        </table>
    </div>
</div>
</body>
</html>