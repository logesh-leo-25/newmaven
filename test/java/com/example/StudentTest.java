from reportlab.lib.pagesizes import letter, landscape
from reportlab.pdfgen import canvas
from reportlab.lib.units import inch
from reportlab.lib import colors

def generate_degree_certificate(student_name, degree, university, affiliation, date):
    # Set file name and orientation
    c = canvas.Canvas(f"{student_name}_certificate.pdf", pagesize=landscape(letter))
    width, height = landscape(letter)

    c.setStrokeColor(colors.darkblue)
    c.setLineWidth(5)
    c.rect(0.5*inch, 0.5*inch, width-1*inch, height-1*inch)

    c.setFont("Helvetica-Bold", 28)
    c.drawCentredString(width/2.0, height - 1.5*inch, university.upper())
    
    c.setFont("Helvetica", 10)
    c.drawCentredString(width/2.0, height - 1.8*inch, affiliation)

    c.setFont("Times-BoldItalic", 36)
    c.drawCentredString(width/2.0, height - 3.0*inch, "Degree Certificate")


    c.setFont("Helvetica", 18)
    c.drawCentredString(width/2.0, height - 3.8*inch, "This is to certify that")
    
    c.setFont("Times-Bold", 30)
    c.drawCentredString(width/2.0, height - 4.5*inch, student_name)

    c.setFont("Helvetica", 18)
    c.drawCentredString(width/2.0, height - 5.2*inch, f"has been awarded the degree of")
    
    c.setFont("Helvetica-Bold", 24)
    c.drawCentredString(width/2.0, height - 5.8*inch, degree)

    c.setFont("Helvetica", 12)
    c.drawString(1.2*inch, 1.5*inch, f"Date: {date}")
    
    c.line(width - 3.5*inch, 1.5*inch, width - 1.2*inch, 1.5*inch)
    c.drawCentredString(width - 2.35*inch, 1.3*inch, "Vice Chancellor / Registrar")

    c.save()
    print(f"Certificate generated: {student_name}_certificate.pdf")


generate_degree_certificate(
    student_name="Arjun Sharma",
    degree="Bachelor of Technology in Computer Science",
    university="Global Institute of Technology",
    affiliation="Affiliated to the State Technical University | Approved by AICTE & UGC",
    date="April 16, 2026"
)
