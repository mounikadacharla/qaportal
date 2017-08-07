import { QAPORTALPage } from './app.po';

describe('qaportal App', function() {
  let page: QAPORTALPage;

  beforeEach(() => {
    page = new QAPORTALPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
